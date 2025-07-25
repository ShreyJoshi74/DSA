class Solution {
    static boolean[] vis ;
    public static void dfs(ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,int node){
        vis[node] = true;
        for(int temp : adj.get(node)){
            if(!vis[temp]) dfs(adj,stack,temp);
        }
        stack.push(node);
        return;
        
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] t : edges){
            adj.get(t[0]).add(t[1]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!vis[i]) dfs(adj,stack,i);
        }
        ArrayList<Integer> output = new ArrayList<>();
        while(!stack.isEmpty()) output.add(stack.pop());
        return output;
        
        
    }
}
