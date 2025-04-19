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
class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int availWire = 0;
        for(int[] wire : connections){
            int u = wire[0];
            int v = wire[1];
            if(ds.findParent(u) != ds.findParent(v)){
                ds.unionBySize(u,v);
            }else{
                availWire++;
            }
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(ds.findParent(i) != ds.findParent(0) && availWire > 0){
                ds.unionBySize(0,i);
                availWire--;
                count++;
            }
            if(ds.findParent(i) != ds.findParent(0)) return -1;
        }
        return count;
    }
}