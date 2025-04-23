class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int maxCount = Integer.MIN_VALUE;
        int count = 0;
        if(s.equals("")) return 0;
        if(s.equals(" ")) return 1;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(!queue.contains(temp)){
                queue.add(temp);
                count++;
                
            }else{
                maxCount = Integer.max(maxCount,count);
                while(queue.peek() != temp){
                    queue.poll();
                    count--;
                }
                queue.poll();
                queue.add(temp);
            }
        }
        maxCount = Integer.max(count,maxCount);
        return maxCount;
    }
}