class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[26][26];

        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < 26; j++) {
                    if (dist[k][j] == INF) continue;
                    long newCost = dist[i][k] + dist[k][j];
                    if (newCost < dist[i][j]) {
                        dist[i][j] = newCost;
                    }
                }
            }
        }

        long total = 0;
        for (int i = 0; i < source.length(); i++) {
            int sc = source.charAt(i) - 'a';
            int tc = target.charAt(i) - 'a';
            if (sc == tc) continue;
            if (dist[sc][tc] >= INF) return -1; 
            total += dist[sc][tc];
        }
        return total;
    }
}