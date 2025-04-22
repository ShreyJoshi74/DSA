class Solution {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        if(n == 1){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());

        }
        int[] out = new int[n];
        Arrays.fill(out,0);
        for(int[] temp : edges){
            adj.get(temp[0]).add(temp[1]);
            adj.get(temp[1]).add(temp[0]);
            out[temp[0]]++;
            out[temp[1]]++;
            
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(out[i] == 1){
                queue.add(i);                
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            result = new ArrayList<>();
            for(int i = 0;i< size ; i++){
                int node = queue.poll();
                result.add(node);
                out[node]--;
                for(int t : adj.get(node)){
                    out[t]--;
                    if(out[t] == 1){
                        queue.add(t);
                    }
                }
            }

        }
        
        return result;
        

        
    }
}