class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();

        int[] arr = new int[c];
        int longest = 0;

        for(int j=0; j<c; j++){
            arr[j] = 1;
            for(int i=0; i<j; i++){
                boolean ok = true;
                for(int k=0; k<r; k++){
                    if(strs[k].charAt(i) > strs[k].charAt(j)){
                        ok = false;
                        break;
                    }
                }
                if(ok) {
                    arr[j] = Math.max(arr[j], arr[i]+1);
                } 
            }
            longest = Math.max(longest, arr[j]);
        }
        return c - longest;
    }
}