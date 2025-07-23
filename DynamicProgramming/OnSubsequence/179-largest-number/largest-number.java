class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> (b+a).compareTo(a+b));
        for(int i = 0; i < nums.length;i++){
            String t = "" + nums[i];
            pq.add(t);
        }
        String s = "";
        if(pq.peek().charAt(0) == '0') return "0";
        while(!pq.isEmpty()) s += pq.poll();
        return s;
    }
}