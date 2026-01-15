class Solution {
    public int maxConsecutive(int[] arr){
        if(arr.length == 1) return 1;
        int globalMax = 1;
        int k = 1;
        for(int i = 1; i < arr.length; i++ ){
            if(arr[i] - arr[i - 1] == 1) k++;
            else k = 1;
            globalMax = Math.max(k,globalMax);
        }
        return globalMax;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int h = maxConsecutive(hBars);
        int v = maxConsecutive(vBars);
        int result = Math.min(h,v) + 1;
        return result * result;
    }
}