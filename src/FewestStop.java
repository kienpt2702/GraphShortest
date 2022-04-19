import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FewestStop {
    List<List<Integer>> adj;
    HashSet<Integer> visited;
    int[] source;
    int[] totalStopFromSource;
    public FewestStop(int v, int s, List<List<Integer>> adj){
        this.adj = adj;
        visited = new HashSet<>();
        source = new int[v];
        totalStopFromSource = new int[v];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        while(!queue.isEmpty()){
            int vertex = queue.removeFirst();
            for(int otherVertex: adj.get(vertex)){
                // if already visited then continue
                if(visited.contains(otherVertex)) continue;
                // else this is the first time - the fewest stop to other bc bfs traverse increasing distance from source
                queue.add(otherVertex);
                visited.add(otherVertex);
                source[otherVertex] = vertex;
                totalStopFromSource[otherVertex] = totalStopFromSource[vertex] + 1;
            }
        }
    }
}
