class Solution {
    int[][] direction = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
    public int minimumTime(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][1] > 1 && matrix[1][0] > 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(visited[i],Integer.MAX_VALUE);
        pq.add(new int[]{0,0,0});

        visited[0][0] = 0;

        while(!pq.isEmpty()){
            
            int[] temp = pq.poll();
            int i = temp[0];
            int j = temp[1];
            int time = temp[2];
            if (time > visited[i][j]) continue;

            for(int[] dir : direction){
                int ni = i + dir[0];
                int nj = j + dir[1];

                    if(ni >= 0 && ni < m &&
                        nj >=0 && nj < n)
                    {
                        if(time + 1 >= matrix[ni][nj] &&
                            time + 1 < visited[ni][nj]){
                                visited[ni][nj] = time+1;
                                pq.add(new int[] {ni,nj,time + 1});
                            }
                        else if(time+1 < matrix[ni][nj]){
                            int nt;
                            if((matrix[ni][nj] - time) % 2 == 0) nt = matrix[ni][nj] + 1;
                            else nt = matrix[ni][nj];
                            if(nt < visited[ni][nj]){
                                visited[ni][nj] = nt;
                                pq.add(new int[] {ni,nj,nt});
                            }
                        }
                    }
            }

            
        }
        return (visited[m-1][n-1] == Integer.MAX_VALUE)? -1 : visited[m-1][n-1];

    }   
}