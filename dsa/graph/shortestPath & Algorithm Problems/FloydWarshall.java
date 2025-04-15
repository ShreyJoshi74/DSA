class Solution {
    public void shortestDistance(int[][] mat) {
       int v = mat.length;
       for(int k = 0; k < v; k++){
           for(int i = 0; i < v; i++){
               for(int j=0; j < mat[0].length; j++){
                   if(i == k || j == k) continue;
                   else if(mat[i][k]+mat[k][j] < mat[i][j]){
                       mat[i][j] = mat[i][k]+mat[k][j];
                   }
               }
           }
       }
       
    }
}
