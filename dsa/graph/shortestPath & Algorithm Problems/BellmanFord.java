class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dis = new int[V];
        Arrays.fill(dis, 100000000);

        dis[src] = 0;
        for(int i = 0; i < V-1; i++){
            for(int[] t : edges){
                int u = t[0];
                int v = t[1];
                int wt = t[2];
                if(dis[u] != 100000000 && dis[u] + wt < dis[v]){
                    dis[v] = dis[u] + wt;
                }
            }
        }
        for(int[] t : edges){
                int u = t[0];
                int v = t[1];
                int wt = t[2];
                if(dis[u] != 100000000 && dis[u] + wt < dis[v]){
                    return new int[]{-1};
                }
            }
        return dis;
    }
}
