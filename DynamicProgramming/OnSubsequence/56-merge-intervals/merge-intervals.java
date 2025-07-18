// so here timeComplexity is required around nlogn
// intuition sort than merge or create new and add to arrayList
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ls = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        ls.add(intervals[0]);
        for(int[] temp : intervals){
            int l = temp[0];
            int h = temp[1];
            int[] prev = ls.get(ls.size()-1);
            if(l > prev[1]) ls.add(new int[]{l,h});
            else{
                if(h > prev[1]){
                    ls.remove(ls.size()-1);
                    ls.add(new int[]{ Math.min(l,prev[0]),h});
                }
            }
            
        }
        int[][] output = new int[ls.size()][2];
        int i = 0;
        for(int[] temp : ls){
            output[i] = temp;
            i++;
        }
        return output;
        
    }
}