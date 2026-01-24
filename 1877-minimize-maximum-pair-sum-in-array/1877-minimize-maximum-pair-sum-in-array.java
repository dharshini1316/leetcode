import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort the array
        int maxSum = 0;
        int i = 0, j = nums.length - 1;

        // Step 2: Pair smallest with largest
        while (i < j) {
            maxSum = Math.max(maxSum, nums[i] + nums[j]);
            i++;
            j--;
        }

        return maxSum; // Step 3: Return minimized maximum pair sum
    }
}