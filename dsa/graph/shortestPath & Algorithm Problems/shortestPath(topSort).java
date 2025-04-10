class Solution {
  public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] dis = new int[N];
        Arrays.fill(dis,Integer.MAX_VALUE);
        boolean[] visited= new boolean[N];
        boolean[] onStack= new boolean[N];
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
            
        }
        for(int[] t : edges){
            List<Integer> temp = new ArrayList<>();
            temp.add(t[1]);
            temp.add(t[2]);
            adj.get(t[0]).add(temp);
        }
        topoSort(0,adj,visited,onStack,stack);
        dis[0] = 0;
        while(!stack.isEmpty()){
            int temp = stack.pop();
            for(List<Integer> s : adj.get(temp)){
                int index = s.get(0);
                int weight = s.get(1);
                dis[index] = Integer.min(dis[index],dis[temp] + weight);
            }
        }
        for(int i = 0; i < N; i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }
        return dis;


  }
  public void topoSort(int node, List<List<List<Integer>>> adj, boolean[] visited, boolean[] onStack, Stack<Integer> stack){
    if(onStack[node]) return;
    onStack[node] = true;
    visited[node] = true;
    for(List<Integer> t : adj.get(node)){
        if(!visited[t.get(0)]){
            topoSort(t.get(0),adj,visited,onStack,stack);
        }
    }
    onStack[node] = false;
    stack.push(node);
  }
}
