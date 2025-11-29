class Solution {
    public void findPossiblePath(List<Integer> ls , int x, int y){
        if(x % y == 0) return;
        ls.add(x % y);
        findPossiblePath(ls,y,x%y);
    }
    public boolean canMeasureWater(int x, int y, int target) {
        List<Integer> possiblePath = new ArrayList<>();
        possiblePath.add(Math.max(x,y));
        possiblePath.add(Math.min(x,y));
        if(target > x + y) return false;
        findPossiblePath(possiblePath,possiblePath.get(0),possiblePath.get(1));
        Queue<Integer> search = new LinkedList<>();
        search.add(0);
        boolean[] visited = new boolean[target + 1];
        while(!search.isEmpty()){
            int currentSum = search.poll();
            visited[currentSum] = true;
            for(int nextMove : possiblePath){
                int nextSum = currentSum + nextMove;
                if(nextSum  == target) return true;
                if(nextSum < target && !visited[nextSum]) search.add(nextSum);
            }
        }
        return false;

    }
}