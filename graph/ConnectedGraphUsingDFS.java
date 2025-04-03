class Graph{
    int vertices;
    List<List<Integer>> adj;
    Graph(int v){
        vertices = v;
        adj = new ArrayList<>();
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
    
    public boolean dfsCycleCheck(int initial,Graph P, boolean[] visited,int prev){
        visited[initial] = true;
        for(int next : P.adj.get(initial)){
            if(next == prev) continue;
            if(visited[next]) return true;
            if (dfsCycleCheck(next, P, visited, initial)) { 
                return true; // ✅ Return true when cycle is found
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
                if(dfsCycleCheck(i,P,visited,-1)){
                    return true;
                }
            }
        }
        return false;
        
        
        
    }
}
