class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totapples = 0;
        for(int i=0; i<apple.length; i++){
            totapples = totapples + apple[i];
        }

        Arrays.sort(capacity);

        int boxused = 0;
        for(int i=capacity.length -1; i>=0 && totapples > 0; i--){
            totapples = totapples - capacity[i];
            boxused++;
        }
        return boxused;
    }
}