class Solution {
    public int[] frequencySort(int[] nums) {
        int[] countNums = new int[201];

        // frequency count
        for (int num : nums) {
            countNums[num + 100]++;
        }

        // box nums
        Integer[] boxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // sort
        Arrays.sort(boxed, (a, b) -> {
            int freqA = countNums[a + 100];
            int freqB = countNums[b + 100];

            if (freqA != freqB) {
                return freqA - freqB;        
            }
            return b - a;                    
        });

      
        for (int i = 0; i < nums.length; i++) {
            nums[i] = boxed[i];
        }

        return nums;
    }
}
