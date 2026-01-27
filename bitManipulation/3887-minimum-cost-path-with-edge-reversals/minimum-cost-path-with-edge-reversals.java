class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        // array contains(v1, w1)
        // v1 -> Destination Edge
        // w1 -> weight
        // [[1,1]]
        // Creating all possible routes
        for(int[] edge : edges){
            int[] arr = new int[2];
            arr[0] = edge[1];
            arr[1] = edge[2];
            adj.get(edge[0]).add(arr);
            //now adding for if edge is reversed;
            int[] arr2 = new int[2];
            arr2[0] = edge[0];
            arr2[1] = 2 * edge[2];
            adj.get(edge[1]).add(arr2);
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // {edge,count}
        // min Heap by comparing count(weight) value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        dis[0] = 0;
        pq.add(new int[] {0,0});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int node = temp[0];
            int count = temp[1];
            // for safety
            if(count < dis[node])
                continue;
            
            for(int[] nextPath : adj.get(node)){
                int nextNode = nextPath[0];
                int pathCost = nextPath[1];
                if(count + pathCost < dis[nextNode]){
                    pq.offer(new int[] {nextNode, count + pathCost});
                    dis[nextNode] = count + pathCost;
                }
            }
            
        }
        return dis[n-1] == Integer.MAX_VALUE ? -1 : dis[n-1];
    }
}