import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();

        
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int end = 0;

        while (end < s2.length()) {
            char c = s2.charAt(end);

            
            if (!need.containsKey(c)) {
                end++;
                start = end;
                have.clear();
                continue;
            }

            
            have.put(c, have.getOrDefault(c, 0) + 1);

            
            while (have.get(c) > need.get(c)) {
                char startChar = s2.charAt(start);
                have.put(startChar, have.get(startChar) - 1);
                start++;
            }

            int windowSize = end - start + 1;

            if (windowSize == s1.length()) {
                return true;
            }

            end++;
        }

        return false;
    }
}