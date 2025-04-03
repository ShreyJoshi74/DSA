class Graph{
    int vertices;
    List<List<Integer>> adj;
    Graph(int v){
        vertices = v;
        adj = new ArrayList<>(vertices);
    }
}
class Pair{
    int curr;
    int prev;
    Pair(int a,int b){
        curr = a;
        prev = b;
    }
}

class Solution {
    public boolean bfsCycleCheck(int initial,Graph P,boolean visited[]){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(initial,-1));
        
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int curr=temp.curr;
            int from = temp.prev;
            visited[curr] = true;
            for(int next : P.adj.get(curr)){
                if(next == from){
                    continue;
                }
                if(visited[next]){
                    return true;
                }
                queue.add(new Pair(next,curr));
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        Graph P = new Graph(V);
        boolean[] visited = new boolean[P.vertices];
        for(int i = 0; i < V; i++){
            P.adj.add(new ArrayList<>());
        }
        for(int[] t : edges){
            P.adj.get(t[0]).add(t[1]);
            P.adj.get(t[1]).add(t[0]);
        }
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(bfsCycleCheck(i,P,visited)){
                    return true;
                }
            }
        }
        return false;
        
        
        
    }
}
