class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.remove(nums[i]);
            }
        }
        Set<Integer> set = map.keySet();
        System.out.println(set);
        Iterator<Integer> it = set.iterator();

        int k = it.next();
        return k;
    }
}