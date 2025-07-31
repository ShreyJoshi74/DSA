class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq1 = new ArrayDeque<>();
        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0; i < k-1; i++){
            while(!dq1.isEmpty() && nums[dq1.peekLast()] < nums[i]) dq1.pollLast();
            dq1.addLast(i);
        }
        for(int i = k-1; i < nums.length; i++){
            while(!dq1.isEmpty() && nums[dq1.peekLast()] < nums[i])
                dq1.pollLast();

            
            dq1.addLast(i);
            while(i - dq1.peekFirst() + 1 > k) dq1.pollFirst();
            output.add(nums[dq1.peekFirst()]);
        }
        int[] a = new int[output.size()];
        for(int i = 0; i < output.size();i++) a[i] = output.get(i);
        return a;

    }
}