class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for (int[] rows : dist) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,0,0});
        dist[0][0] = 0;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            int effort = temp[0];
            if(i == row-1 && j == col -1) return effort;
            for(int[] dir : direction){
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni >= 0 && ni < row && nj >= 0 && nj < col){
                    int maxEffort = heights[ni][nj] - heights[i][j];
                    if(maxEffort < 0) maxEffort = maxEffort * -1;
                    maxEffort = Integer.max(effort,maxEffort);
                    if(maxEffort < dist[ni][nj]){
                        dist[ni][nj] = maxEffort;
                        pq.add(new int[]{maxEffort,ni,nj});
                    }

                }
            }
        }
        return -1; 
    }
}