class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial penalty: shop closed all day
        for (char c : customers.toCharArray()) {
            if (c == 'Y') penalty++;
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