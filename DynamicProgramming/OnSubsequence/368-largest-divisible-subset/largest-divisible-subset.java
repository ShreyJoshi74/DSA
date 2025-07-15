class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] hash = new int[nums.length];
        int[] size = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            hash[i] = i;
            size[i] = 1;
        }
        int lastElement = 0;
        int max = 0;
        for(int i = 1; i < nums.length ; i++){
            for(int j = 0; j < i; j++){
                if((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && size[i] < size[j] + 1){
                    size[i] = size[j] + 1;
                    hash[i] = j;
                }
            }
            if(max < size[i]){
                max = size[i];
                lastElement = i;
            }
        }
        List<Integer> ls = new ArrayList<>();
        while(hash[lastElement] != lastElement){
            ls.add(0,nums[lastElement]);
            lastElement = hash[lastElement];
        }
        ls.add(0,nums[lastElement]);
        return ls;
    }
}