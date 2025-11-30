class Solution {
    int[][] direction = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int dfs(int[][] grid,int i,int j){
        if(grid[i][j] == 0) return 1;
        if(grid[i][j] == 3) return 0;
        grid[i][j] = 3;
        int sum = 0;
        for(int[] dir : direction){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length){
                sum += dfs(grid,ni,nj);
            }
            else sum += 1;

        }
        return sum;
    }
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sum += dfs(grid,i,j);
                }
            }
        }
        return sum;
    }
}