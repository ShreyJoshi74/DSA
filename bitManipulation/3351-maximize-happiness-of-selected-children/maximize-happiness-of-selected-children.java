class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int i = happiness.length - 1;
        int round = 0; long output = 0;
        while(i >= 0 && k > 0){
            int happy = happiness[i] - round;
            if(happy <= 0) break;
            output += happy;
            round++;
            k--;
            i--;


        }
        return output;
    }
}