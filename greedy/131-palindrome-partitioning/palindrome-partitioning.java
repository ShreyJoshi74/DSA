class Solution {
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void combi(String s,List<String> temp,List<List<String>> ls){
        if(s == ""){
            ls.add(new ArrayList<>(temp));
            
        }
        for(int i = 0; i < s.length(); i++){
            String tem = s.substring(0,i+1);
            if(isPalindrome(tem)){
                temp.add(tem);
                combi(s.substring(i+1,s.length()),temp,ls);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        combi(s,temp,ls);
        return ls;
    }
}