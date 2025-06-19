class Solution {
    public void combi(String digits, int i, String[] dic, List<String> ls, StringBuilder temp) {
        if (i == digits.length()) {
            ls.add(temp.toString());
            return;
        }

        int index = digits.charAt(i) - '0';
        for (int j = 0; j < dic[index].length(); j++) {
            temp.append(dic[index].charAt(j));  // add
            combi(digits, i + 1, dic, ls, temp);
            temp.deleteCharAt(temp.length() - 1);  // backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        if (digits.length() == 0) return ls;

        String[] dic = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        combi(digits, 0, dic, ls, new StringBuilder());
        return ls;
    }
}
