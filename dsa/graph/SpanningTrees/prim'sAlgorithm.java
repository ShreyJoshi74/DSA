class Pair{
    int distance;
    int node;
    Pair(int a, int b){
        distance = a;
        node = b;
    }
}
class Solution {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Prims Algorithm
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.distance,b.distance));
        int sum = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int distance = temp.distance;
            int node = temp.node;
            if(vis[node]) continue;
            sum = sum + distance;
            vis[node] = true;
            for(int[] s : adj.get(node)){
                if(!vis[s[0]]) pq.add(new Pair(s[1],s[0]));
            }
        }
        return sum;
        
    }
}
