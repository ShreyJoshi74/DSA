class Solution {
    // trying brutforce first
    public int minimumPairRemoval(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int num : nums)
            ls.add(num);
        int count = 0;
        while(ls.size() > 1){
            
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;
            boolean isNonDecreasing = true;

            for(int i = 0; i < ls.size() - 1; i++){
                int sum = ls.get(i) + ls.get(i + 1);
                if(sum < minSum){
                    minSum = sum;
                    minIndex = i;

                }
                if(ls.get(i) > ls.get(i + 1))
                    isNonDecreasing = false;
                
            }
            if(isNonDecreasing)
                break;
            ls.set(minIndex, minSum);
            ls.remove(minIndex + 1);
            count++;
        }
        return count;
    }   
}