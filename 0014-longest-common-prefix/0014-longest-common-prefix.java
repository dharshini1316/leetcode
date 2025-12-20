class Solution {
    public String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) return "";

        String S = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(S)) {
                S = S.substring(0, S.length() - 1);
                if (S.isEmpty()) return "";
            }
        }
        return S;
    }
}