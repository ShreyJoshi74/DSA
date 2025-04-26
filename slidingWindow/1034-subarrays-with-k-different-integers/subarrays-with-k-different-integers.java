// I am thinking of potli approach applying it for k will give me list > =  k 
// So thinking of result = subArrays(k) - subArrays(k+1)
// potli approach on top
// TLE aagaya lol
// making it for < k result = subArrays(k) - subArrays(k-1)

class Solution {
    
    public int subArrays(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        int r = 0 ,cnt = 0,j = 0;
        while(r < nums.length){
            if(k < 0) return 0;
            if(map.containsKey(nums[r])){
                map.put(nums[r],map.get(nums[r])+1);
                
            }else{
                map.put(nums[r],1);

            }
            while(map.keySet().size() > k){
                int temp = map.get(nums[j]);
                if(temp == 1){
                    map.remove(nums[j]);
                    
                }else{
                    temp--;
                    map.put(nums[j],temp);
                }
                j++;

            }
            cnt += r - j + 1;
        
            r++;
            

            
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArrays(nums,k) - subArrays(nums,k-1);
    }
}