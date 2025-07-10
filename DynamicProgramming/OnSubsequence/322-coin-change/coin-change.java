class Solution {
    
    public int coinChange(int[] coins, int amount) {
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
       pq.add(new int[] {0,0});
       int[] totalSikke = new int[amount+1];
       Arrays.fill(totalSikke,Integer.MAX_VALUE);
        totalSikke[0] = 0;
       while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int sum = temp[0];
            int sikke = temp[1];
            for(int rupay : coins){
                long next =(long) sum + rupay;
                if(next <= amount && sikke + 1 < totalSikke[(int)next]){
                    totalSikke[(int)next] = sikke + 1;
                    pq.add(new int[]{(int)next,sikke + 1});
                }
            }
       }
       return (totalSikke[amount] != Integer.MAX_VALUE) ? totalSikke[amount] : -1;
    }   
}