class Solution {
    public boolean isBipartite(int[][] graph) {
        char[] color = new char[graph.length];
        for(int i = 0 ; i < graph.length; i++){
            color[i] = 'N';
        }
        for(int i = 0; i < graph.length; i++){
            if(color[i] == 'N'){
                if(!dfs(i,graph,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node,int[][] graph, char[] color,int order){
        if(color[node] == 'N'){
            if(order % 2 == 0){
                color[node] = 'G';
                for(int s : graph[node]){
                    if(color[s]=='G'){
                        return false;
                    }
                }
            }else{
                color[node] = 'Y';
                for(int s : graph[node]){
                    if(color[s]=='Y'){
                        return false;
                    }
                }
            }
        }
        for(int s : graph[node]){
            if(color[s] == 'N'){
                if(!dfs(s,graph,color,order+1)){
                    return false;
                }
            }
        }
        return true;
    }
}