// I am thinking of potli approach applying it for k will give me list > =  k 
// So thinking of result = subArrays(k) - subArrays(k+1)
// potli approach on top
// TLE aagaya lol
// making it for < k result = subArrays(k) - subArrays(k-1)

class Solution {
    public int subArrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0, cnt = 0, j = 0;
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }

            cnt += r - j + 1;
            r++;
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrays(nums, k) - subArrays(nums, k - 1);
    }
}
