class Solution {
    int MOD = 1_000_000_007;
    public int countPermutations(int[] complexity) {
        int min = complexity[0];
        long permutation = 1;
        for(int i = 1; i < complexity.length; i++){
            if(complexity[i] <= min) return 0;
            permutation =( permutation * (complexity.length - i) % MOD) % MOD;
        }
        return (int) permutation;
    }
}