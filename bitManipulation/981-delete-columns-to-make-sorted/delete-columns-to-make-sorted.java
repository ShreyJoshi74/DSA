class Solution {
    public boolean isSorted(String[] strs, int index){
        int count = Integer.MIN_VALUE;

        for(int i = 0; i < strs.length; i++){
            if(count > (int) strs[i].charAt(index)){
                return false;
            }
            count =(int) strs[i].charAt(index);
            
        }

        return true;
    }
    public int minDeletionSize(String[] strs) {
        int count = 0;

        for(int i = 0; i < strs[0].length(); i++) {
            if(!isSorted(strs,i)) count++;
        }

        return count;
    }
}