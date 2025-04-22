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
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        if(n == 1){
            return 1;
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Disjoint ds = new Disjoint(n * n);
        int otherSize = Integer.MIN_VALUE;
        // step 1 making unions
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1){
                    int num = i * n + j;
                    for(int[] dir : directions){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1){
                            int nei = nr * n + nc;
                            ds.unionBySize(num,nei);
                            otherSize = Integer.max(otherSize,ds.size[ds.findParent(num)]);
                        }
                    }
                }
            }
        }
        
        // Step 2 flipping every 0 and checking max size we get
        int maxSize = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int size = 0;
                // set for a good reason understand it
                Set<Integer> set = new HashSet<>();
                if(grid[i][j] == 0){
                    size  = 1;
                    for(int[] dir : directions){
                        int nr = i + dir[0];
                        int nc = j + dir[1];
                        if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1){
                            int nei = nr * n + nc;
                            set.add(ds.findParent(nei));
                        }
                    }
                    for(int s : set){
                        size += ds.size[s];
                    }
                    // getting max size here
                    maxSize = Integer.max(maxSize,size);
                }
            }
        }
        return Integer.max(maxSize,otherSize);
    }
}