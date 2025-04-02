class Solution {
    private void dfss(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node,ArrayList<Integer> finall){
        vis[node] = true;
        finall.add(node);
        for(int i:adj.get(node)){
            if(!vis[i]){
                
                dfss(adj,vis,i,finall);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        ArrayList<Integer> finall = new ArrayList<>();
        dfss(adj,vis,0,finall);
        return finall;
        
    }
}
