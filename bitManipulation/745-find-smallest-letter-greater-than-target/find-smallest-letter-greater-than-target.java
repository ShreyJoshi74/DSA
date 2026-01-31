class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        
        int ans = 'z' + 1;
        int low = 0;
        int high = letters.length - 1;
        while(low <= high){
            int mid = (low + high) >> 1;

            if( target < letters[mid] && letters[mid] < ans ){
                ans = letters[mid];
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans == 'z' + 1 ? letters[0] : (char) ans;
    }
}