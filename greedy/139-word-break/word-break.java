class Solution {
    public boolean segment(int i,List<String> wordDict,String s,Boolean[] done){
        boolean k;
        
        if(i == s.length()) return true;
        if(done[i] != null) return done[i];
        for(int j = i; j < s.length();j++){
            String t = s.substring(i,j+1);
            if(wordDict.contains(t)){
                k = segment(j+1,wordDict,s,done);
                System.out.println(t);
                if(k) {
                    done[i] = true;
                    return true;
                }
        }
        
        }
        done[i] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] done = new Boolean[s.length()];
        return segment(0,wordDict,s,done);
    }
}