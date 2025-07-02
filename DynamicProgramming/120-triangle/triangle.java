class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[][] dp =new  int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,triangle,dp);

    }
    public int f(int day,int path,List<List<Integer>> triangle,int[][] dp){
        if(day >= triangle.size()) return 0;
        if(dp[day][path] != -1) return dp[day][path];
        int min = Integer.MAX_VALUE;
        min = Math.min(min,triangle.get(day).get(path) + f(day + 1,path,triangle,dp));
        min = Math.min(min,triangle.get(day).get(path) + f(day + 1,path+1,triangle,dp));
        return dp[day][path] = min;
        
    }
}