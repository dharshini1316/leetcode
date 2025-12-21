class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = 0;
        int currcount = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                currcount++;
                if(currcount > maxcount){
                    maxcount = currcount;
                }
            }
            else{
                currcount = 0;
            }
        }
        return maxcount;
    }
}