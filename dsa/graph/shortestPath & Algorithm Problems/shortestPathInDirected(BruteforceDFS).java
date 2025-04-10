class Solution {

    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(e[1]); // destination
            pair.add(e[2]); // weight
            adj.get(e[0]).add(pair);
            
        }
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        boolean[] onStack = new boolean[V];
        dis[0] = 0;
        dfs(0,adj,onStack,0,dis);
        for(int i = 0; i < V; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;
    }
    public void dfs(int vertex,ArrayList<ArrayList<ArrayList<Integer>>> adj,boolean[] onStack,int w,int[] dis){
        if(onStack[vertex]) return;
        onStack[vertex] = true;
        for(ArrayList<Integer> s : adj.get(vertex) ){
            if(!onStack[s.get(0)]){
                dis[s.get(0)] = Integer.min(dis[s.get(0)], w + s.get(1));
                dfs(s.get(0),adj,onStack,w + s.get(1),dis);
            }
        }
        onStack[vertex] = false;
    }
}
