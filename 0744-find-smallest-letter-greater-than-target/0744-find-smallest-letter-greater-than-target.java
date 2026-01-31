class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        while(left <= right) {
            int mid = (right + left) / 2;

            if(letters[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if(left < letters.length) {
            return letters[left];
        } else {
            return letters[0];
        }
    }
}