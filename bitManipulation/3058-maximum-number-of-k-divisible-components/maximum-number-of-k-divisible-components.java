class Solution {
    int count = 0;
    boolean[] vis ;
    public int dfs(int node,List<List<Integer>> adj,int[] values, int k){
        // if(adj.get(node).size() == 0){
        //     if(values[node] % k == 0){
        //         count++;
        //         return 0;
        //     }
        //     else return values[node];
        // }
        List<Integer> currAdj = adj.get(node);
        int sum = values[node];
        vis[node] = true;
        for(int nextNode : currAdj){
            
            if(!vis[nextNode]){
                sum += dfs(nextNode,adj,values,k);
            } 
        }
        if(sum % k == 0){
            count++;
            return 0;
        }
        return sum % k;
       
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        this.vis = new boolean[n];
        int trash = dfs(0,adj,values,k);
        return count;
        


    }
}