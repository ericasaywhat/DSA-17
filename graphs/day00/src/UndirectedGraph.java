import java.util.*;

public class UndirectedGraph implements Graph {
    HashMap<Integer,List<Integer>> graph;
    ArrayList<Integer> vert;

    public UndirectedGraph(int n) {
        graph = new HashMap<>();
        //O(n)
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        vert = new ArrayList<>(graph.keySet());
    }

    @Override
    //O(1)
    public void addEdge(int v, int w) {
        graph.get(v).add(w);
        graph.get(w).add(v);
    }

    @Override
    //O(1)
    public List<Integer> vertices() {
    	return vert;
    }

    @Override
    //O(1)
    public int numVertices() {
        return vert.size();
    }

    @Override
    //O(v)
    public int numEdges() {
        int edges = 0;
        for (List<Integer> value:graph.values()){
            edges += value.size();
        }
        return edges/2;
    }

    @Override
    //O(1)
    public Iterable<Integer> getNeighbors(int v) {
    	return graph.get(v);
    }

    @Override
    public boolean hasEdgeBetween(int v, int w) {
        return graph.get(v).contains(w);
    }

}
