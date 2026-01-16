class Solution {
    int MOD = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> vSet = giveAllPossible(vFences,n);
        Set<Integer> hSet = giveAllPossible(hFences,m);

        long inter = Integer.MIN_VALUE;
        for(int i : vSet){
            if(hSet.contains(i))
                inter = Math.max(i,inter);
        }

        if(inter == Integer.MIN_VALUE) return -1;

        return (int) ((inter * inter) % this.MOD);
    }
    public Set<Integer> giveAllPossible(int[] fence, int border){
        Set<Integer> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        for(int fen : fence) ls.add(fen);
        ls.add(1);
        ls.add(border);
        Collections.sort(ls);
        for(int i = 0; i < ls.size(); i++){
            for(int j = i + 1; j < ls.size(); j++){
                set.add(ls.get(j) - ls.get(i));
            }
        }
        return set;
    }
}