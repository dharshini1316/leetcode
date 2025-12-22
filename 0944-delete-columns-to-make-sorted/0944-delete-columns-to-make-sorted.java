class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();

        int count = 0;

        for(int j=0; j<c; j++){
            for(int i=1; i<r; i++){
                if(strs[i].charAt(j) < strs[i-1].charAt(j)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}