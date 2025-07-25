class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] nxt = new int[nums.length];
        Arrays.fill(nxt,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <=2* nums.length;i++){
            while(!stack.isEmpty() && nums[i%nums.length] > nums[stack.peek()]){
                int k = stack.pop();
                nxt[k] = nums[i%nums.length];
            }
            stack.push(i%nums.length);

        }
       
        return nxt;
        
    }
}