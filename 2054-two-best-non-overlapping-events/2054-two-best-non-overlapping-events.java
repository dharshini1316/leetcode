import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        int ans = 0;

        for (int[] e : events) {
            int start = e[0], end = e[1], value = e[2];

           
            int bestBefore = map.floorEntry(start - 1).getValue();

            ans = Math.max(ans, bestBefore + value);

           
            map.put(end, Math.max(map.lastEntry().getValue(), value));
        }

        return ans;
    }
}