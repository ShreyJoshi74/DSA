class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int[][] direction = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int n = grid.length;
        if(grid[0][0] == 0 && n == 1){
            return 1;
        }
        if(grid[0][0] == 1 && n > 1 || grid[n-1][n-1]==1 && n > 1 ){
            return -1;
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] t = q.poll();
            int i = t[0];
            int j = t[1];
            int depth = t[2];
            for(int[] d : direction){
                int ni = i + d[0];
                int nj = j + d[1];
                if(ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj]== 0){
                    if(ni == n-1 && nj == n-1){
                        return depth + 1;
                    }
                    if(!visited[ni][nj]){
                        q.add(new int[]{ni,nj,depth + 1});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        return -1;
    }
}