class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b) -> Double.compare(b,a));

        double sum = 0;

        for(int num : nums){
            pq.add((double) num);
            sum += num;
        }

        double target = sum / 2;
        int ops = 0;

        while(!pq.isEmpty() && sum > target){
            double ele = pq.poll();
            sum -= ele / 2;
            ops++;
            pq.add(ele / 2);
        }
        return ops;

        
        
    }
}