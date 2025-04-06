class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
         List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < V; i++){
             adj.add(new ArrayList<>());
         }
         for(int[] ed : edges){
             adj.get(ed[0]).add(ed[1]);
         }
         boolean[] visited = new boolean[V];
         Stack<Integer> stack = new Stack<>();
         for(int i = 0 ; i < V; i++){
             if(!visited[i]){
                 dfs(i,stack,visited,adj);
             }
         }
         ArrayList<Integer> output = new ArrayList<>();
         while(!stack.isEmpty()){
             output.add(stack.pop());
         }
         return output;
    }
    public static void dfs(int vertex,Stack<Integer> stack,boolean[] visited,List<List<Integer>> adj){
        visited[vertex] = true;
        for(int s : adj.get(vertex)){
            if(!visited[s]){
                dfs(s,stack,visited,adj);
            }
        }
        stack.push(vertex);
    }
}
