class Solution {
    public void combi(String digits,int i,String[] dic,List<String> ls,String temp){
        if(i == digits.length()){
            ls.add(temp);
            return;
        }
        int index =  digits.charAt(i) - '0';
        for(int j = 0; j < dic[index].length(); j++){
            temp = temp + dic[index].charAt(j);
            combi(digits,i+1,dic,ls,temp);
            temp = temp.substring(0,temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        if(digits.length() == 0) return ls;
        String[] dic = {" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String temp = "";
        combi(digits,0,dic,ls,temp);
        return ls;
    }
}