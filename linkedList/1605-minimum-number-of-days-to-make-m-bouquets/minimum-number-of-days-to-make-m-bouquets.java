class Solution {
    public int findBouquet(int[] bloomDay,int currentDay,int flowerRequired){
        int bouquet = 0;
        int flower = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] > currentDay) flower = 0;
            else{
                flower++;
                if(flower == flowerRequired){
                    bouquet++;
                    flower = 0;
                }
            }
        }
        return bouquet;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0,h = Integer.MIN_VALUE,ans = -1,mid = -1,possibleBouquet;
        for(int i = 0; i < bloomDay.length; i++) h = Math.max(h,bloomDay[i]);
        while(l <= h){
            mid = (l + h)/2;
            possibleBouquet = findBouquet(bloomDay,mid,k);
            if(possibleBouquet >= m){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}