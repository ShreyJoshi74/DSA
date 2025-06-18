class Solution {
    public void combi(int[] nums, int i, List<Integer> temp, Set<List<Integer>> ls) {
        if (i == nums.length) {
            ls.add(new ArrayList<>(temp));
            return;
        }

        // Don't include nums[i]
        combi(nums, i + 1, temp, ls);

        // Include nums[i]
        temp.add(nums[i]);
        combi(nums, i + 1, temp, ls);
        temp.remove(temp.size() - 1); // backtrack
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to group duplicates
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        combi(nums, 0, temp, set);
        return new ArrayList<>(set); // Convert set back to list
    }
}
