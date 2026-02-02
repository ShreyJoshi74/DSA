class Solution {
    private int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> ls = new ArrayList<>();
        int[] sum = new int[n];
        int currSum = 0;
        for(int i = 0; i < n; i++){
            currSum += nums[i];
            sum[i] = currSum % MOD;
        }
        
        for(int i = 0; i < n; i++){
            
            for(int j = i ; j < n; j++){
                int temp = sum[j];

                if(i > 0)
                    temp -= sum[i - 1];
                ls.add(temp);

            }
        }
        Collections.sort(ls);
        int k = ls.size();
        int output = 0;
        for(int i = left - 1; i <= (right - 1) & i < k; i++)
            
            output =( output + ls.get(i)) % MOD;
        return output;
    }
}