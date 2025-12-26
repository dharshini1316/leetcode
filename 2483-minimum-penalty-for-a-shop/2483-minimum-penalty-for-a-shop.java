class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        char[] arr = customers.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'Y'){
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;  // open avoids a missed customer
            } else {
                penalty++;  // open causes idle hour
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }
        return bestHour;
    }
}