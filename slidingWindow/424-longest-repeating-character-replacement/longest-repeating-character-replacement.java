class Solution {
    public int maxFreq(int[] hash){
        int maxIndex = 0;
        for(int i = 0; i < 26; i++){
            if(hash[i] > hash[maxIndex]){
                maxIndex = i;
            }
        }
        return hash[maxIndex];
    }

    public int characterReplacement(String s, int k) {
        int j = 0;
        int i = 0;
        int maxCount = 0;
        int count = 0;
        int changes;
        int[] hash =new int[26];
        Arrays.fill(hash,0);
        for(i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'A']++;
            changes = i - j + 1 - maxFreq(hash);
            if(changes <=k){
                count++;
                maxCount = Math.max(maxCount , count);
            }else{
                while(i - j + 1 - maxFreq(hash) > k){
                    hash[s.charAt(j) - 'A']--;
                    j++;
                    
                }
                count = i - j + 1;
            }
        }
        return maxCount;
    }
}