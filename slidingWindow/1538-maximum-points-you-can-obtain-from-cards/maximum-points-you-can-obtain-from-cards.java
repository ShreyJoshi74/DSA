class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lr = 0 , lj = 0;
        int rr = cardPoints.length - 1, rj = cardPoints.length - 1;
        int leftSum = 0, rightSum = 0;
        if(k >= cardPoints.length){
            for(int p : cardPoints){
                leftSum += p;

            }
            return leftSum;
        }
        for(int i = 0; i<k;i++){
            leftSum += cardPoints[lr];
            lr++;
            rightSum += cardPoints[rr];
            rr--;
        }
        lr--;
        rr++;
        int optimalSum = 0;
        while(k > 0){
            if(leftSum >= rightSum){
                optimalSum += cardPoints[lj];
                leftSum -= cardPoints[lj];
                lj++;
                rightSum -= cardPoints[rr];
                rr++;
                k--;
            }else{
                optimalSum += cardPoints[rj];
                rightSum -= cardPoints[rj];
                rj--;
                leftSum -= cardPoints[lr];
                lr--;
                k--;

            }
        }
        return optimalSum;
    }

    
}