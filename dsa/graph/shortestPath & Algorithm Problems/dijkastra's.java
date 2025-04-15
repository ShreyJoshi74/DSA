class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] t : edges){
            int node = t[0];
            List<Integer> temp = new ArrayList<>();
            temp.add(t[1]);
            temp.add(t[2]);
            adj.get(node).add(temp);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0] , b[0]));
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);

        dis[src] = 0;
        pq.add(new int[] {0,src});
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int wt = t[0];
            int node = t[1];
            for(List<Integer> s : adj.get(node)){
                if(wt + s.get(1) < dis[s.get(0)]){
                    dis[s.get(0)] =wt + s.get(1);
                    pq.add(new int[] {dis[s.get(0)],s.get(0)});
                }
            }
        }
        return dis;
        
        
    }
}
