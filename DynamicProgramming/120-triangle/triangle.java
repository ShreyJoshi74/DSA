class Solution {
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int m = triangle.size();
    //     int n = triangle.get(triangle.size()-1).size();
    //     int[][] dp =new  int[m][n];
    //     for(int i = 0; i < m; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return f(0,0,triangle,dp);

    // }
    // public int f(int day,int path,List<List<Integer>> triangle,int[][] dp){
    //     if(day == triangle.size()-1){
    //         int x = triangle.get(day).get(path);
           
    //         return x;
    //     }

        
    //     if(dp[day][path] != -1) return dp[day][path];
    //     int min = Integer.MAX_VALUE;
    //     min = Math.min(min,triangle.get(day).get(path) + f(day + 1,path,triangle,dp));
    //     min = Math.min(min,triangle.get(day).get(path) + f(day + 1,path+1,triangle,dp));
    //     return dp[day][path] = min;
        
    // }
    public int minimumTotal(List<List<Integer>> triangle){
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++){
            dp[m-1][i] = triangle.get(m-1).get(i);
        }
        
        if(m > 1){
            for(int i = m-2; i>=0; i--){
                for(int j = 0; j < triangle.get(i).size(); j++){
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
            }
        }
        return dp[0][0];
    }
}