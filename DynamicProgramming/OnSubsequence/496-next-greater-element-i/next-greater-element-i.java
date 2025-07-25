class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> out = new ArrayList<>();
        int[] nxt = new int[nums2.length];
        Arrays.fill(nxt,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums2.length;i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int k = stack.pop();
                nxt[k] = i;
            }
            stack.push(i);
        }
        for(int i = 0; i< nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    out.add(nxt[j]);
                    
                }
            }
        }
        int[] ls = new int[out.size()];
        Arrays.fill(ls,-1);
        for(int i = 0; i < out.size();i++){
            int o = out.get(i);
            if(o!=-1)ls[i] = nums2[out.get(i)];
        }
        return ls;
    }
}