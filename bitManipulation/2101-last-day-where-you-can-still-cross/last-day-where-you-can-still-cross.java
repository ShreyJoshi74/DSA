class Solution {
    int[][] direction = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean dfs(int i, int j, int[][] mat){
        if(i == mat.length - 1) return true;
        mat[i][j] = 1;

        for(int[] dir : direction){
            int ni = i + dir[0];
            int nj = j + dir[1];

            if(ni >= 0 && ni < mat.length && nj >= 0 && nj < mat[0].length && mat[ni][nj] == 0){
                if(dfs(ni,nj,mat)) return true;
            }
        }
        return false;
    }
    public boolean isWalkPossible(int row, int col, int[][] cells, int day){
        int[][] mat = new int[row][col];

        for(int i = 0; i <= day; i++){
            int[] cell = cells[i];
            mat[cell[0] - 1][cell[1] - 1] = 1;
        }

        for(int i = 0; i < col; i++){
            if(mat[0][i] == 0 && dfs(0 , i, mat)) return true;
        }
        return false;

    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int i = 0;
        int j = cells.length - 1;
        int ans = -1;
        while(i <= j){
            int mid = (i + j) >> 1;

            if(isWalkPossible(row,col,cells,mid)){
                i = mid + 1;
                ans = mid;
            }else{
                j = mid - 1;
            }

        }
        return ans + 1;

    }
}