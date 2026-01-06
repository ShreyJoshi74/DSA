class Solution {
    public int numberOfSpecialChars(String word) {
        
        int[] smallFirst = new int[26];
        int[] smallLast = new int[26];
        int[] capFirst = new int[26];
        int[] capLast = new int[26];

        Arrays.fill(smallFirst , Integer.MAX_VALUE);
        Arrays.fill(capFirst , Integer.MAX_VALUE);
        Arrays.fill(smallLast , Integer.MIN_VALUE);
        Arrays.fill(capLast , Integer.MIN_VALUE);
        int i = -1;
        for(char c : word.toCharArray()){
            i++;
            if(c >= 97 && c < 123){
                smallFirst[c - 'a'] = Math.min(smallFirst[c-'a'] , i);
                smallLast[c - 'a'] = Math.max(smallFirst[c-'a'] , i);
            }else{
                capFirst[c - 'A'] = Math.min(capFirst[c - 'A'] , i);
                capLast[c - 'A'] = Math.max(capFirst[c - 'A'] , i);
            }
        }
        int count = 0;
        for(int j = 0; j < 26; j++){
            if(smallFirst[j] == Integer.MAX_VALUE || capFirst[j] == Integer.MAX_VALUE) continue;
            if(smallFirst[j] < capFirst[j] && smallLast[j] < capFirst[j]) count++;
        }
        return count;
    }
}