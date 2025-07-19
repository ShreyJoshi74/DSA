class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int l = Integer.MIN_VALUE;
        int cnt = 0;
        for(int[] temp : intervals){
            if(temp[0] >= l) {
            l = temp[1];
            cnt++;
            }
        }
        return intervals.length - cnt;
    }
}