class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
             ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
             int[] inDegree = new int[V];
             Queue<Integer> q = new LinkedList<>();
             for(int i = 0 ; i < V ; i++){
                 inDegree[i] = 0;
                 adj.add(new ArrayList<>());
             }
             for(int[] ed : edges){
                 inDegree[ed[1]]++;
                 adj.get(ed[0]).add(ed[1]);
             }
             for(int i = 0; i < V; i++) {
                if(inDegree[i] == 0) q.add(i);
             }
             ArrayList<Integer> output = new ArrayList<>();
             while(!q.isEmpty()){
                 int temp = q.poll();
                 output.add(temp);
                 for(int i : adj.get(temp)){
                     inDegree[i]--;
                     if(inDegree[i] == 0) q.add(i);
                 }
             }
             return output;
    }
    
}
