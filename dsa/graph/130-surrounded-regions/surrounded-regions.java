class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean[][] cannotBeVisited = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length; i++){
            if(board[i][0] == 'O'){
                dfs(board,cannotBeVisited,i,0,visited);
            }
        }
        for(int i = 0 ; i < board.length; i++){
            if(board[i][board[0].length - 1] == 'O'){
                dfs(board,cannotBeVisited,i,board[0].length-1,visited);
            }
        }
        for(int i = 0 ; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                dfs(board,cannotBeVisited,0,i,visited);
            }
        }
        for(int i = 0 ; i < board[0].length; i++){
            if(board[board.length - 1][i] == 'O'){
                dfs(board,cannotBeVisited,board.length-1,i,visited);
            }
        }
        for(int i = 1 ; i < board.length ; i++){
            for (int j = 1 ; j < board[0].length ; j++){
                if(board[i][j]=='O' && !cannotBeVisited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board,boolean[][] cannotBeVisited, int r,int c,boolean[][] visited){
       int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
       cannotBeVisited[r][c] = true;
       visited[r][c] = true;
       for(int[] s : dir ){
        int nr = r + s[0];
        int nc = c + s[1];
        if(nr >= 0 && nr < board.length && nc >=0 && nc < board[0].length){
            if(board[nr][nc] == 'O' && !visited[nr][nc]){
                dfs(board,cannotBeVisited,nr,nc,visited);
            }
        }
       }
    }
}