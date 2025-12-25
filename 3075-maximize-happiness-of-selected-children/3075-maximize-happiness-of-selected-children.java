class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
        int n = hap.length;
        long sum = 0;

        for (int i = 0; i < k; i++) {
            int value = hap[n - 1 - i] - i; 
            if (value > 0) sum += value;
        }

        return sum;
    }
}