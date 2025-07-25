class Solution {
    public int trap(int[] height) {
        int output = 0;
        int left  = 0;
        int[] arr = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length;i++){
            while(!stack.isEmpty() && height[i] >= height[left]){
                int k = stack.pop();
                arr[k] = Math.max(height[left] - height[k],arr[k]);
            }
            stack.push(i);
            if(height[i] >= height[left]) left = i;
        }
        Stack<Integer> rstack = new Stack<>();
        int right = height.length-1;
        for(int i = height.length - 1; i >= 0;i--){
            while(!rstack.isEmpty() && height[i] >= height[right]){
                int k = rstack.pop();
                arr[k] = Math.max(height[right] - height[k],arr[k]);
            }
            rstack.push(i);
            if(height[i] >= height[right]) right = i;
            
        }
        for(int i : arr) output+=i;
        return output;
    }
}