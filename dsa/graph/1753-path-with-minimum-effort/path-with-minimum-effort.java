class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [effort, i, j]
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (i == row - 1 && j == col - 1) return effort;

            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                    int diff = Math.abs(heights[ni][nj] - heights[i][j]);
                    int maxEffort = Math.max(effort, diff);
                    if (maxEffort < dist[ni][nj]) {
                        dist[ni][nj] = maxEffort;
                        pq.add(new int[]{maxEffort, ni, nj});
                    }
                }
            }
        }

        return -1; // Should never hit here
    }
}
