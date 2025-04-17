class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());

        }
        for(int[] edge : flights){
            List<Integer> temp = new ArrayList<>();
            temp.add(edge[1]);
            temp.add(edge[2]);
            adj.get(edge[0]).add(temp);
        }
        Queue<int[]> q = new LinkedList<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        q.add(new int[]{0,src,0});
        dist[src] = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            int stop = temp[0];
            int node = temp[1];
            int cost = temp[2];
            if(stop > k) break;
            for(List<Integer> s : adj.get(node)){
                if(cost + s.get(1) < dist[s.get(0)]){
                    dist[s.get(0)] = cost + s.get(1);
                    q.add(new int[]{stop + 1 , s.get(0),dist[s.get(0)]});
                }
            }
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 :dist[dst];
    }
}