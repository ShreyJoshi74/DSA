class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                high++;
                low++;
            }else if(s.charAt(i) == ')'){
                if(low > 0) low--;
                high--;
            }else{
                if(low > 0) low--;
                high++;
            }
            if(high < 0) return false;
        }
        return low == 0;
    }
}