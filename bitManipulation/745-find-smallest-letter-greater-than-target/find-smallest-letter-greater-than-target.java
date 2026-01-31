class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        
        int ans = 'z' + 1;
        for(int i = 0; i < letters.length; i++){
            if(target < letters[i] && letters[i] < ans)
                ans = letters[i] ;
        }
        
        return ans == 'z' + 1 ? letters[0] : (char) ans;
    }
}