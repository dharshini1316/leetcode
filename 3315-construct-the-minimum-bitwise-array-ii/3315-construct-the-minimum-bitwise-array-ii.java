import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num == 2) {
                ans[i] = -1;
            } else if ((num & 3) == 1) {
                ans[i] = num - 1;
            } else {
                int v = num + 1;
                int k = Integer.toBinaryString(v & -v).length() - 1;
                int mask = (1 << k) - 1;
                int high_bits = num & ~mask;
                int low_bits = (1 << (k - 1)) - 1;
                ans[i] = high_bits | low_bits;
            }
        }
        return ans;
    }
}