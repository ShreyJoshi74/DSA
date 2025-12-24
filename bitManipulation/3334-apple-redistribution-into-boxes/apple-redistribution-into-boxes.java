class Solution {
    public int minimumBoxes(int[] apples, int[] capacity) {
        int sum = 0;
        for(int apple : apples) sum += apple;

        Arrays.sort(capacity);

        int i = capacity.length-1, count = 0;

        for(; i >= 0; i--){
            sum -= capacity[i];
            count++;
            if(sum <= 0) return count;
        }
        return -1;
    }
}