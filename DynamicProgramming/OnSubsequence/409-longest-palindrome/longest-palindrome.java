class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int odd = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
            if(map.get(c) % 2 == 0) odd--;
            else odd++;
        }
        System.out.println(odd);
        return (odd > 0) ? s.length() - odd  + 1: s.length();
    }
}