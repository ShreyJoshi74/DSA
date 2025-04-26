class Solution {
    public String minWindow(String s, String t) {
        int r = 0, j = 0;
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> charq = new LinkedList<>();
        Queue<Integer> indexq = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        String minString = "";
        boolean start = false;

        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i) , map.get(t.charAt(i)) + 1);

            }else{
                map.put(t.charAt(i),1);
            }
        }
        while(r < s.length()){
            if(map.containsKey(s.charAt(r))){
                map.put(s.charAt(r),map.get(s.charAt(r)) - 1);
                charq.add(s.charAt(r));
                indexq.add(r);
            }
            while(!charq.isEmpty() && map.get(charq.peek()) < 0 ){
                map.put(charq.peek(),map.get(charq.peek()) + 1);
                indexq.poll();
                charq.poll();

                j = indexq.peek();
            }
            while( j < s.length() && !map.containsKey(s.charAt(j)) ){
                j++;
            }
            if(!start){
                for(Map.Entry<Character,Integer> e : map.entrySet()){
                    if(e.getValue() > 0){
                        start = false;
                        break;
                    }
                    start = true;
                }
            }
            if(start){
                String temp = s.substring(j,r+1);
                if(temp.length() < minLength){
                    minString = temp;
                    minLength = temp.length();
                }
            }
            r++;
            
        }
        return minString;
    }
}