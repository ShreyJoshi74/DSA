class Solution {
    public boolean lemonadeChange(int[] bills) {
        int coin5 = 0, coin10 = 0, coin20 = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5) coin5++;
            else if(bills[i] == 10){
                if(coin5 == 0) return false;
                coin5--;
                coin10++;
            }
            else{
                if(coin10 >0 && coin5 > 0){
                    coin10--;
                    coin5--;
                }else if(coin5 >= 3){
                    coin5 = coin5 - 3;
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}