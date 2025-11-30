class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for(int ele : nums) sum = ((sum + ele) % p);
        int target = sum % p;
        if(target == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int prefix = 0;
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            prefix = (prefix + nums[i]) % p;
            int need = (prefix - target + p) % p;
            if(map.containsKey(need)){
                res = Math.min(res,i - map.get(need));
            }
            map.put(prefix , i);

        }
        return (res == nums.length) ? -1 : res;
    }
}