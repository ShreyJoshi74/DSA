class Solution {
    public int findSpecialInteger(int[] arr) {
        int step = arr.length/4;
        for(int i = 0; i + step < arr.length; i++){
            if(arr[i] == arr[i + step]) return arr[i];
            
        }
        return -1;
    }
}