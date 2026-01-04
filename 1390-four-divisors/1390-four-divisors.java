class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalsum = 0;

        for(int j=0; j<nums.length; j++){
            int n = nums[j];
            int sum = 0;
            int count = 0;

            for(int i=1; i*i<=n; i++){
                if(n%i == 0){
                    int d1 = i;
                    int d2 = n/i;

                    if(d1 == d2){
                        count++;
                        sum = sum + d1;
                    } else {
                        count = count + 2;
                        sum = sum + d1 + d2;
                    }
                    if(count > 4) {
                        break;
                    }
                }
            }
            if(count == 4) {
                totalsum = totalsum + sum;
            }
        }
        return totalsum;
    }
}