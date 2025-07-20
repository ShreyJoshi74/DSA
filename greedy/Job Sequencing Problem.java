class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        // profit,deadline
        int maxi = 0;
        for(int i = 0; i < deadline.length; i++){
            maxi = Integer.max(deadline[i] , maxi);
            pq.add(new int[]{profit[i],deadline[i]});
        }
        int[] arr = new int[maxi];
        Arrays.fill(arr,-1);
        int total = 0,days = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int dead = temp[1];
            int pro = temp[0];
            int i = dead - 1;
            while(i >= 0){
                if(arr[i] == -1){
                    arr[i] = 0;
                    total +=  pro;
                    days++;
                    break;
                }
                i--;
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(days);
        output.add(total);
        return output;
        
        
        
    }
}
