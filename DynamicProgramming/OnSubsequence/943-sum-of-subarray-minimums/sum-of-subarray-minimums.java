class Solution {
    // 3 , 1 , 2, 3, 2, 1
    //3, 1 + 1,2 + 2, 
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length];
        for(int curr= 0; curr < arr.length; curr++){
            int popcnt = 0;
            while(!stack.isEmpty() && arr[curr] <= arr[stack.peek()]){
                popcnt++;
                stack.pop();
            }
            int mul;
            if(stack.isEmpty()) {
                mul = curr + 1;
                dp[curr] = (arr[curr] * mul)  ;
            }
            else {
                mul = curr - stack.peek() ;
                dp[curr] = (arr[curr] * mul + dp[stack.peek()] );
            }

            
            stack.push(curr);
        }
        int output = 0;
        for(int i = 0; i < arr.length; i++) output  = (output +  dp[i])  % (int) (1e9 + 7);
        return output  % (int) (1e9 + 7);
    }
}