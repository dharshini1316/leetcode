class Solution {
    public int minDeletionSize(String[] strs) {
        int r = strs.length, c = strs[0].length();
        String[] built = new String[r];
        Arrays.fill(built, "");
        int delcount = 0;

        for (int col = 0; col < c; col++) {
            String[] temp = built.clone();
            for (int row = 0; row < r; row++) {
                temp[row] += strs[row].charAt(col);
            }
            if (isSorted(temp)) {
                built = temp;
            } else {
                delcount++;
            }
        }
        return delcount;
    }

    private boolean isSorted(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) return false;
        }
        return true;
    }
}