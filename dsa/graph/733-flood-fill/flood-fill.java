import java.util.*;

class Pair {
    int row, col;
    Pair(int a, int b) {
        row = a;
        col = b;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length, cols = image[0].length;
        int originalColor = image[sr][sc];

        // If the new color is the same as the original, no need to process
        if (originalColor == color) return image;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color; // Mark visited by coloring it

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int row = temp.row, col = temp.col;

            // Explore all 4 directions
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];

                // Check boundary and if the pixel has the original color
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                        && image[newRow][newCol] == originalColor) {
                    image[newRow][newCol] = color; // Change color
                    queue.add(new Pair(newRow, newCol)); // Enqueue for further exploration
                }
            }
        }

        return image;
    }
}
