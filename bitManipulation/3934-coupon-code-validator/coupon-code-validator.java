class Solution {
    List<String> businessLines = new ArrayList<>(
        Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
    );


    
    public boolean isCodeValid(String str){
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if((c >= 65 && c <= 90) || (c >= 48 && c <= 57) || (c >= 97 && c <= 122) || c == '_') cnt++;
        }
        if(cnt == str.length()) return true;
        return false;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String,List<String>> map = new HashMap<>();


        for(int i = 0; i < code.length; i++){
            if(!businessLines.contains(businessLine[i])) continue;
            if(!isActive[i]) continue;
            if(code[i].equals("") || !isCodeValid(code[i])) continue;
            if(map.containsKey(businessLine[i])){
                List<String> list = map.get(businessLine[i]);
                list.add(code[i]);
                map.put(businessLine[i] , list);
            }else {
                List<String> ls = new ArrayList<>();
                ls.add(code[i]);
                map.put(businessLine[i],ls);
            }


        }

        List<String> output = new ArrayList<>();

        for(String str : businessLines){
            if(map.containsKey(str)) { 
                List<String> results = map.get(str);
                Collections.sort(results);
                for(String result : results) output.add(result);
            }
            

        }
        return output;


    }
}