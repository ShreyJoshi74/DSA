class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGas = 0, totalGas = 0,totalCost = 0;
        int index =0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            currGas = currGas + gas[i] - cost[i];
            if(currGas < 0) {
                index = (i+1)%gas.length;
                currGas = 0;
            }
            
        }
        if(totalCost > totalGas) return -1;
        return index;
    }
}