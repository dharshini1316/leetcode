class Solution {
    public int[] getConcatenation(int[] arr) {
        int n = arr.length;
        int[] newarr = new int[2 * n];

        for (int i = 0; i < n; i++) {
            newarr[i] = arr[i];       
            newarr[i + n] = arr[i];   
        }

        return newarr;
    }
}