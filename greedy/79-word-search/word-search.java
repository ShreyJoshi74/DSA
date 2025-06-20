class Solution {
    public boolean dfs(String word,int i,int j,char[][] board,boolean[][] onStack,int index,int[][] dir){
        if(index == word.length()) return true;
        onStack[i][j] = true;
        for(int[] t : dir){
            int ni = i + t[0];
            int nj = j + t[1];
            if(ni >=0 && ni < board.length && nj >= 0 && nj < board[0].length && !onStack[ni][nj] && board[ni][nj] == word.charAt(index) ){
                if(dfs(word,ni,nj,board,onStack,index+1,dir)) return true;
            }

        }
        onStack[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] onStack = new boolean[m][n];
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(word,i,j,board,onStack,1,dir)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}