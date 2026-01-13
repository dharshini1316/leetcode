class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        List<int[]> events = new ArrayList<>();
        for (int[] sq : squares) {
            int y = sq[1], len = sq[2];
            totalArea += (double) len * len;
            events.add(new int[]{y, +1, len});       
            events.add(new int[]{y + len, -1, len});
        }
        Collections.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        double halfArea = totalArea / 2.0;
        double cumArea = 0;
        long width = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0], type = e[1], len = e[2];
            
            if (y > prevY) {
                double segmentHeight = (double)(y - prevY);
                
                double areaGain = width * segmentHeight;
                if (cumArea + areaGain >= halfArea) {
                    
                    double needed = halfArea - cumArea;
                    return prevY + needed / width;
                }
                cumArea += areaGain;
                prevY = y;
            }
            
            width += (type == 1 ? len : -len);
        }
        return prevY;
    }
}