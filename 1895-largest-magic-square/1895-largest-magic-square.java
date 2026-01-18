class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Prefix sums for rows and columns
        int[][] rowPrefix = new int[m][n+1];
        int[][] colPrefix = new int[m+1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j+1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[i+1][j] = colPrefix[i][j] + grid[i][j];
            }
        }

        int maxK = 1; // every 1x1 is trivially magic

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; i + k <= m && j + k <= n; k++) {
                    if (isMagic(grid, rowPrefix, colPrefix, i, j, k)) {
                        maxK = Math.max(maxK, k);
                    }
                }
            }
        }
        return maxK;
    }

    private boolean isMagic(int[][] grid, int[][] rowPrefix, int[][] colPrefix,
                            int r, int c, int k) {
        int target = rowPrefix[r][c+k] - rowPrefix[r][c];

        // check rows
        for (int i = r; i < r + k; i++) {
            int sum = rowPrefix[i][c+k] - rowPrefix[i][c];
            if (sum != target) return false;
        }

        // check cols
        for (int j = c; j < c + k; j++) {
            int sum = colPrefix[r+k][j] - colPrefix[r][j];
            if (sum != target) return false;
        }

        // check diagonals
        int diag1 = 0, diag2 = 0;
        for (int d = 0; d < k; d++) {
            diag1 += grid[r+d][c+d];
            diag2 += grid[r+d][c+k-1-d];
        }
        return diag1 == target && diag2 == target;
    }
}