class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = newInterval[0];
        int h = newInterval[1];
        int i = 0;
        ArrayList<int[]> ls = new ArrayList<>();
        for(i = 0; i < intervals.length; i++){
            if(h < intervals[i][0]) break;
            else if(intervals[i][1] < l) ls.add(intervals[i]);
            else{
                l = Math.min(l,intervals[i][0]);
                h = Math.max(h,intervals[i][1]);
            }

        }
        ls.add(new int[]{l,h});
        while(i < intervals.length){
            ls.add(intervals[i]);
            i++;
        }
        int[][] out = new int[ls.size()][2];
        for(int j = 0; j < ls.size(); j++){
            out[j] = ls.get(j);
        }
        return out;
    }
}