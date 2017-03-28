import java.util.*;

public class GraphProblems {

    private static List<Integer> dfs1(Graph g, int v, List<Integer> visited, List<Integer> topo){
        visited.add(v);
        for(int neighbor: g.getNeighbors(v)){
            if (!visited.contains(neighbor)){
                dfs1(g, neighbor, visited, topo);
            }
        }
        topo.add(0, v);
        return topo;
    }

    private static boolean dfs2(Graph g, int v, List<Integer> visited, int parent){
        visited.add(v);
        for(int neighbor: g.getNeighbors(v)){
            if (!visited.contains(neighbor)){
                return dfs2(g, neighbor, visited,  v);
            } else if (neighbor != parent) return true;

        }
        return false;
    }

    public static boolean connected(Graph g, int v, int u) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();

        q.offer(v);
        while(!q.isEmpty()){
            int vert = q.poll();
            if(vert == u) return true;

            for(int n : g.getNeighbors(vert)){
                if(!visited.contains(n)){
                    visited.add(n);
                    q.add(n);
                }
            }

        }
        return false;
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        List<Integer> visited = new ArrayList<>();
        List<Integer> topo = new ArrayList<>();
        for(int vert : g.vertices()){
            if(!visited.contains(vert)) dfs1(g, vert,visited, topo);
        }
        return topo;
    }

    public static boolean hasCycle(UndirectedGraph g) {
        List<Integer> visited = new ArrayList<>();
        int parent = -1;
        for(int vert : g.vertices()){
            if(!visited.contains(vert)) {
                if (dfs2(g, vert,visited, parent)) return true;
                parent = vert;
            }
        }
        return false;
    }

}