class Solution {
    public int numMagicSquaresInside(int[][] g) {
        int r = g.length, c = g[0].length, ans = 0;
        for (int i = 0; i + 2 < r; i++)
            for (int j = 0; j + 2 < c; j++)
                if (magic(g, i, j)) ans++;
        return ans;
    }

    boolean magic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                int v = g[r+i][c+j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        int s = g[r][c] + g[r][c+1] + g[r][c+2];
        return g[r+1][c]+g[r+1][c+1]+g[r+1][c+2]==s &&
               g[r+2][c]+g[r+2][c+1]+g[r+2][c+2]==s &&
               g[r][c]+g[r+1][c]+g[r+2][c]==s &&
               g[r][c+1]+g[r+1][c+1]+g[r+2][c+1]==s &&
               g[r][c+2]+g[r+1][c+2]+g[r+2][c+2]==s &&
               g[r][c]+g[r+1][c+1]+g[r+2][c+2]==s &&
               g[r][c+2]+g[r+1][c+1]+g[r+2][c]==s;
    }
}