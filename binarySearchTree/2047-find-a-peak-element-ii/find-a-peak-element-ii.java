class Solution {
    public int findMax(int[][] mat,int col){
        int maxElement = -1;
        int index = 0;
        for(int i = 0; i < mat.length; i++){
            if(maxElement < mat[i][col]){
                maxElement =mat[i][col];
                index = i;
            }
            
        }
        return index;
        
    }
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            int row = findMax(mat,mid);

            int current = mat[row][mid];

            int left = (mid >= 1) ? mat[row][mid-1] : -1;

            int right = (mid < mat[0].length - 1 ) ? mat[row][mid+1] : -1;

            if(current > right && current > left) return new int[] {row,mid};

            if(current < right) low = mid + 1;
            else high = mid - 1;

            

        }
        return new int[]{-1,-1};
    }
}

