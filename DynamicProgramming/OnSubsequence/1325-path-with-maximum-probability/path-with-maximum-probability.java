class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int i = 0;
        for(int[] temp : edges){
            adj.get(temp[0]).add(new double[]{temp[1],succProb[i]});
            adj.get(temp[1]).add(new double[]{temp[0],succProb[i]});
            i++;
        }
        //PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[1],b[1]));
        //pq.add(new double[]{0,1}); 
        //boolean[] vis = new boolean[n];
        double prob = 1;
        double[] dist = new double[n];
        Arrays.fill(dist,0);
        Queue<Integer> q = new LinkedList<>();
        q.add(start_node);
        dist[start_node] = 1;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(double[] nei : adj.get(curr)){
                int node = (int) nei[0];
                double rate = nei[1];
                if(dist[curr] * rate > dist[node]){
                    dist[node] = dist[curr] * rate;
                    q.add(node);
                }
            }
        }
        return dist[end_node];

        
    }
}