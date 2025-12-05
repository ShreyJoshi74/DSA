class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0;
        for(int ele : batteries) total += ele;
        long high = total / n;
        long low = 0;
        long ans = -1;
        while(low <= high){
            long mid = (low + high) >> 1;
            if(canRun(n,batteries,mid)) {
                ans = mid;
                low = mid+1;
            }else high = mid - 1;

        }
        return ans;
    }
    public boolean canRun(int n, int[] batteries,long time){
        long canrun = 0;
        for(int battery : batteries){
             canrun += Math.min(battery,time);
        }
        return canrun >= n * time;
    }
}