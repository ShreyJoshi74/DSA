class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        int globalCount= 0;
        for(char c : set){
            int j = 0;
            int count = 0;
            int r = k;
            int allow = 0;
            int maxCount = 0;
            for(int i = 0; i < s.length();i++){
                if(s.charAt(i) == c){
                    count++;
                    maxCount = Math.max(maxCount,count);
                }else{
                    if(allow < r){
                        allow++;
                        count++;
                        maxCount= Math.max(maxCount,count);
                    }else{
                        while(s.charAt(j)== c){
                            j++;
                            count--;
                        }
                        j++;
                    }
                }

            }
            globalCount = Math.max(maxCount,globalCount);
        }
        return globalCount;
    }
}