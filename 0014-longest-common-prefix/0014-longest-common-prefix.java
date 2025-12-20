class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String S = strs[0];

        for (int i = 1; i < strs.length; i++) {
            
            while (!strs[i].startsWith(S)) {
                S = S.substring(0, S.length() - 1);
                if (S.isEmpty()) return "";
            }
        }
        return S;
    }
}