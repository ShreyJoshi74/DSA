class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        for(int i = 0; i <= n; i++){
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        for(int[] t : times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        dist[k] = 0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int node = temp[0];
            int cost = temp[1];
            for(int[] t : adj.get(node)){
                int next = t[0];
                int newcost = cost + t[1];
                if(newcost < dist[next]){
                    dist[next] = newcost;
                    pq.add(new int[]{next,newcost});
                }
            }
        }
        
        int max = 0;
        for(int i = 1 ; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Integer.max(max,dist[i]);
        }
        return max;
    }
}