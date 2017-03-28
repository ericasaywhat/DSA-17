import java.util.*;

public class ShortestPath {

    private static HashMap<Integer,Integer> mHash;


    public static List<Integer> shortestPath(Graph g, int v, int w) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        List<Integer> newPath = new ArrayList<>();
        boolean flag = true;

        if(distanceBetween(g,v,w) == -1) return null;
        path.add(w);
        q.add(w);
        while (!q.isEmpty()){
            int vert = q.poll();
            for(int neighbor : g.getNeighbors(vert)){
                if(mHash.get(neighbor) != null) {
                    if ((mHash.get(neighbor) < mHash.get(vert)) && flag){
                        q.add(neighbor);
                        path.add(neighbor);
                        flag = false;
                    }
                }
            }
            flag = true;
        }

        int index = path.size()-1;
        while(index >= 0) {
            newPath.add(path.get(index));
            index--;
        }

        return newPath ;

    }

    public static int distanceBetween(Graph g, int v, int w) {
        mHash = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        mHash.put(v,0);
        q.offer(v);
        while (!q.isEmpty()){
            int vert = q.poll();
            if (vert==w) return mHash.get(w);
            if (visited.contains(vert)) return -1;
            else visited.add(vert);
            for (int neighbor: g.getNeighbors(vert)){
                if (!visited.contains(neighbor)&& !q.contains(neighbor))q.add(neighbor);
                if(mHash.containsKey(neighbor)){
                    if(mHash.get(neighbor)>mHash.get(vert)+1) mHash.put(neighbor, mHash.get(vert)+1);
                }
                else mHash.put(neighbor, mHash.get(vert)+1);
            }
        }

        if (mHash.get(w) == null) return -1;
        else return mHash.get(w);
    }

}