class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] route = new int[n][n];
        for(int i = 0 ; i < n; i++){
            Arrays.fill(route[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int earlyStart = grid[0][0];
        min = Integer.min(min,grid[0][0]);
        max = Integer.max(max,grid[0][0]);
        route[0][0] = max - min;
        int height = max ;
        pq.add(new int[] {height,0,0,min,max});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            height = temp[0];
            int i = temp[1];
            int j = temp[2];
            min = temp[3];
            max = temp[4];
            for(int[] dir : directions){
                int nr= i + dir[0];
                int nc = j + dir[1];
                if(nr >= 0 && nr < n && nc >=0 && nc < n ){
                    int newMax = Integer.max(max,grid[nr][nc]);
                    int newMin = Integer.min(min,grid[nr][nc]);
                    int newHeight = newMax;
                    if(Integer.max(newHeight,earlyStart) < route[nr][nc]){
                        route[nr][nc] = Integer.max(newHeight,earlyStart);
                        pq.add(new int[]{newHeight,nr,nc,newMin,newMax});
                    }
                }
            }
        }
        return route[n-1][n-1] ;

        
    }
}