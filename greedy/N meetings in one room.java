class Solution {

    public int maxMeetings(int[] start, int[] end) {
       ArrayList<int[]> ls = new ArrayList<>();
       for(int i = 0;i < start.length; i++){
            int[] temp = new int[] {start[i],end[i]};
            ls.add(temp);
       }
       Collections.sort(ls,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return Integer.compare(a[1],b[1]);
            }
       });
       if(ls.size() == 0) return 0;
       int[] temp = ls.get(0);
       int lastEnd = temp[1];
       int cnt = 1;
       for(int i = 1; i < ls.size(); i++){
            int[] curr = ls.get(i);
            if(lastEnd < curr[0]){
                cnt++;
                lastEnd = curr[1];
            }
       }
       return cnt;
    }
}
