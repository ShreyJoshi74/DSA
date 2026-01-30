class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Check diagonals starting from first row
        for (int col = 0; col < n; col++) {
            if (!checkDiagonal(matrix, 0, col)) return false;
        }

        // Check diagonals starting from first column (skip [0][0])
        for (int row = 1; row < m; row++) {
            if (!checkDiagonal(matrix, row, 0)) return false;
        }

        return true;
    }

    private boolean checkDiagonal(int[][] matrix, int r, int c) {
        int val = matrix[r][c];
        while (r < matrix.length && c < matrix[0].length) {
            if (matrix[r][c] != val) return false;
            r++;
            c++;
        }
        return true;
    }
}
