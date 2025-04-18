class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //floyd algorithm
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0;j < n; j++){
                if(i == j){
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int[] t : edges){
            mat[t[0]][t[1]] = t[2];
            mat[t[1]][t[0]] = t[2];
        }
        for(int v = 0; v < n; v++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i == v || j == v) continue;
                    if(mat[i][v] == Integer.MAX_VALUE || mat[v][j] == Integer.MAX_VALUE) continue;
                    mat[i][j] = Integer.min(mat[i][v]+mat[v][j],mat[i][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int curr = 0;
        for(int i= 0 ; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j]<= distanceThreshold) count++;
            }
            if(count <= min){
                curr = i;
                min = Integer.min(min,count);
            }
            
        }
        return curr;
    }
}