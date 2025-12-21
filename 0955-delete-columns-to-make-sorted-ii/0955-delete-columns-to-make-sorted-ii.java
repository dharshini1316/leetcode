class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length;
        int c = strs[0].length();
        int delcount = 0;

        boolean[] sorted = new boolean[r - 1];

        for(int i=0; i<c; i++){
            boolean delcol = false;

            for(int j=0; j<r-1; j++){
                if(!sorted[j] && strs[j].charAt(i) > strs[j+1].charAt(i)){
                    delcol = true;
                    break;
                }
            }
            if(delcol){
                delcount++;
            } else {
                for(int j=0; j<r-1; j++){
                    if(!sorted[j] && strs[j].charAt(i) < strs[j+1].charAt(i)){
                        sorted[j] = true;
                    }
                }
            }
        }
        return delcount;
    }
}