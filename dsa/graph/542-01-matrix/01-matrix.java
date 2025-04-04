import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Initialize distances and enqueue all zeroes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Mark as unvisited
                }
            }
        }
        
        // Step 2: BFS from all zeroes
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return dist;
    }
}
