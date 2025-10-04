class Solution {
    public int maxArea(int[] height) {
        if(height.length <= 1) return 0;
        int i = 0;
        int j = height.length -1;
        int max = Integer.MIN_VALUE;
        while(i < j){
            int area = (j - i) * (Math.min(height[i],height[j]));
            max = Math.max(area,max);
            if(height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }
}