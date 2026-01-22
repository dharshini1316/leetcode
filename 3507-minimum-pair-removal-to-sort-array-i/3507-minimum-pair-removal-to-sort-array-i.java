import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {

        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            a.add((long) nums[i]);
        }

        int count = 0;

        while (true) {
            boolean ok = true;
            for (int i = 1; i < a.size(); i++) {
                if (a.get(i) < a.get(i - 1)) {
                    ok = false;
                    break;
                }
            }
            if (ok) break;

            int idx = 0;
            long minSum = a.get(0) + a.get(1);

            for (int i = 1; i < a.size() - 1; i++) {
                long sum = a.get(i) + a.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            a.set(idx, minSum);
            a.remove(idx + 1);

            count++;
        }

        return count;
    }
}