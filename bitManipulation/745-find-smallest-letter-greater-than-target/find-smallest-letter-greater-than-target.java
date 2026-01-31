class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < letters.length; i++){
            if(target < letters[i] && letters[i] < ans)
                ans = letters[i] ;
        }
        
        return ans == Integer.MAX_VALUE ? letters[0] : (char) ans;
    }
}