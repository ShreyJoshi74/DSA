class Solution {
    public int minDeletion(String s, int k) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        int eligible = 0;
        Arrays.sort(count);
        for(int i = 25 ; i >= 0; i--){
          
            eligible += count[i];
            k--;
            if(k == 0) break;
        }
        return s.length() - eligible;

    }
}