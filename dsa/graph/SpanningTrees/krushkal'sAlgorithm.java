class Disjoint{
    int n;
    int[] rank;
    int[] parent;
    int[] size;
    Disjoint(int n){
        this.n = n;
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i <= n; i++){
            rank[i] = 0;
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int u){
        if(u == parent[u]){
            return u;
        }
        parent[u] = findParent(parent[u]);
        return parent[u];
    }
  // rank wali approach
    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        }else if(rank[ulp_u] > rank[ulp_v]){
            parent[ulp_v] = ulp_u;
        }else{
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
    // size wali liye
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return;
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Edges implements Comparable<Edges>{
    int wt;
    int src;
    int end;
    Edges(int wt,int src,int end){
        this.wt = wt;
        this.src = src;
        this.end = end;
    }
    public int compareTo(Edges compareTo){
        return this.wt - compareTo.wt;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edges> edges = new ArrayList<>();
        for(int i = 0; i < V; i++){
            for(int[] ed : adj.get(i)){
                Edges temp = new Edges(ed[1],i,ed[0]);
                edges.add(temp);
                
            }
        }
        Disjoint ds = new Disjoint(V);
        Collections.sort(edges);
        int mstWt =0;
        for(Edges temp : edges){
            int weight = temp.wt;
            int u = temp.src;
            int v = temp.end;
            if(ds.findParent(u) != ds.findParent(v)){
                mstWt += weight;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
        
    }
}
