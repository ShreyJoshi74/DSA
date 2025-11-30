class Solution {
    public boolean isNext(String str1, String str2){
        int count = 0;  
        for(int i = 0; i < 8; i++){
            if(str1.charAt(i) != str2.charAt(i) ){
                count++;

            }
            if(count > 1) return false;
        }
        return true;

    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        Map<String,Integer> map = new HashMap<>();
        map.put(startGene,0);
        while(!queue.isEmpty()){
            String currentString = queue.poll();
            if(currentString.equals(endGene)) return map.get(currentString);
            for(String nextString : bank){
                if(!map.containsKey(nextString) && isNext(currentString,nextString)){
                    map.put(nextString,map.get(currentString) + 1);
                    queue.add(nextString);
                }
            }
            
        }
        return -1;

    }
}