class Solution {
    public int minSteps(String s, String t) {
        int count = 0;
        int[] sDic = new int[26];
        int[] tDic = new int[26];

        for(int i = 0; i < s.length(); i++) sDic[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) tDic[t.charAt(i) - 'a']++;

        for(int i = 0; i < 26; i++) count += Math.abs(sDic[i] - tDic[i]);

        return count;
    }
}