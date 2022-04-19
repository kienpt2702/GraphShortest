import java.util.*;

public class Dijkstra {
    // pq will stores 2 int: vertex that the edge points to and the cost so far
    // adj list stores both vertex that points to and cost originally
    PriorityQueue<int[]> pq;
    List<List<int[]>> adj;
    int[] dist_to;
    int[] source;
    public Dijkstra(int v, int s, List<List<int[]>> adj){
        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        this.adj = adj;
        dist_to = new int[v];
        source = new int[v];
        Arrays.fill(dist_to, Integer.MAX_VALUE);
        dist_to[s] = 0;
        pq.offer(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] min = pq.poll();
            int vertex = min[0];
            int min_cost = min[1];
            // remove outdated element vertex, cost in pq
            if(dist_to[vertex] < min_cost) continue;
            for(int[] edge: adj.get(vertex)){
                // relax step
                int otherVertex = edge[0];
                int costToOtherVertex = min_cost + edge[1];
                if(costToOtherVertex < dist_to[otherVertex]){
                    dist_to[otherVertex] = costToOtherVertex;
                    source[otherVertex] = vertex;
                    pq.offer(new int[]{otherVertex, costToOtherVertex});
                }
            }
        }
    }
}
