class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Compute overlapping width
                int xOverlap = Math.min(topRight[i][0], topRight[j][0])
                             - Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                // Compute overlapping height
                int yOverlap = Math.min(topRight[i][1], topRight[j][1])
                              - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                // If there's real overlap
                if (xOverlap > 0 && yOverlap > 0) {
                    // Side of largest possible square
                    int side = Math.min(xOverlap, yOverlap);
                    long area = (long) side * side;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}