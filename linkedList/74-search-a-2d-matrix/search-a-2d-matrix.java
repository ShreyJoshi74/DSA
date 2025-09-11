class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ans = -1;
        int low = 0;
        int high = matrix.length - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(matrix[mid][0] <= target){
                ans = mid;
                low = mid + 1;
            }else high = mid - 1;
        }
        if(ans == -1) return false;
        if(matrix[ans][0] == target) return true;
        int ans2 = -1;
        low = 0;
        high = matrix[0].length - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(matrix[ans][mid] == target) return true;
            else if(matrix[ans][mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}