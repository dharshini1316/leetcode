import java.util.Arrays;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // Find longest consecutive removable horizontal bars
        int maxH = findMaxConsecutiveGap(hBars);
        // Find longest consecutive removable vertical bars
        int maxV = findMaxConsecutiveGap(vBars);

        // The side length of the square hole is limited by the smaller of the two directions
        int side = Math.min(maxH, maxV);

        // Return the area of the square
        return side * side;
    }

    // Helper to compute max consecutive removable gap
    private int findMaxConsecutiveGap(int[] bars) {
        // Sort positions so we can find consecutive runs
        Arrays.sort(bars);

        int maxRun = 1;
        int currRun = 1;
        for (int i = 1; i < bars.length; i++) {
            // If current bar is exactly 1 after previous, they form a sequence
            if (bars[i] == bars[i - 1] + 1) {
                currRun++;
            } else {
                // Reset on break in sequence
                currRun = 1;
            }
            // Track longest run
            maxRun = Math.max(maxRun, currRun);
        }
        // If k bars are in a run, they create a gap of length (k + 1)
        return maxRun + 1;
    }
}