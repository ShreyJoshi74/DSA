
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            for(int[] s : dir){
                int nr = r + s[0];
                int nc = c + s[1];
                if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length){
                    if(mat[nr][nc] > mat[r][c]+1){
                        mat[nr][nc] = mat[r][c]+1;
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return mat;
    }
}