class Solution {
    public int candy(int[] ratings) {
        int[] candy1 = new int[ratings.length];
        int[] candy2 = new int[ratings.length];
        Arrays.fill(candy1,1);
        Arrays.fill(candy2,1);
        for(int i = 0; i < ratings.length-1; i++){
            if(ratings[i+1] > ratings[i]){
                candy1[i+1] = candy1[i] + 1;
            }
        }
        for(int i = ratings.length-1; i >= 1; i--){
            if(ratings[i-1] > ratings[i]){
                candy2[i-1] = candy2[i] + 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < ratings.length; i++){
            sum = sum + Math.max(candy1[i] , candy2[i]);
        }
        return sum;
    }
}