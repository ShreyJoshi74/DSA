class Solution {
    boolean[][] pacific;
    boolean[][] atlanta;
    public void dfs(int i, int j,char which,int[][] direction,int[][] heights){
        boolean[][] curr;
        if(which =='p') curr = pacific;
        else curr = atlanta;
        if(curr[i][j]) return;
        curr[i][j] = true;
        for(int[] dir : direction){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni >= 0 && ni < curr.length && nj >= 0 && nj < curr[0].length && heights[ni][nj] >= heights[i][j]){
                dfs(ni,nj,which,direction,heights);
            }
        }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        pacific = new boolean[m][n];
        atlanta = new boolean[m][n];
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < n; i++){
            dfs(0,i,'p',direction,heights);
            dfs(m-1,i,'a',direction,heights);
        }
        for(int i = 0; i < m; i++){
            dfs(i,0,'p',direction,heights);
            dfs(i,n-1,'a',direction,heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlanta[i][j]){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    result.add(ls);
                }
            }
        }
        return result;
    }
}