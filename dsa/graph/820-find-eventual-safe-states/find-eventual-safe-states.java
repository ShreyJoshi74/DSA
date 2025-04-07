class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> output = new ArrayList<>();
        int[] outDegree = new int[graph.length];
        boolean[] onStack = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            boolean[] visited = new boolean[graph.length];
            if(isSafe(i,onStack,visited,graph)){
                output.add(i);
            }
        }
        Collections.sort(output);
        return output;
        
    }
    public boolean isSafe(int v , boolean[] onStack , boolean[] visited,int[][] graph){
        if(onStack[v]){
            return false;
        }
        if(visited[v]){
            return true;
        }
        onStack[v] = true;
        visited[v] = true;
        for(int s : graph[v] ){
            if(!isSafe(s,onStack,visited,graph)){
                return false;
            }
        }
        onStack[v] = false;
        return true;

    }
}