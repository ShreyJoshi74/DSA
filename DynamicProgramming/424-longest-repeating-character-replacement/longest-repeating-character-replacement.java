class Solution {
    

    public int characterReplacement(String s, int k) {
        int j = 0;
        int i = 0;
        int maxFreq = 0;
        int count = 0;
        int maxCount = 0;
       
        int[] hash =new int[26];
        Arrays.fill(hash,0);
        for(i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'A']++;
            maxFreq = Math.max(hash[s.charAt(i)-'A'],maxFreq);

            if(i - j + 1 - maxFreq > k){
                hash[s.charAt(j) - 'A']--;
                j++;
            }
            count = i - j + 1;
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}