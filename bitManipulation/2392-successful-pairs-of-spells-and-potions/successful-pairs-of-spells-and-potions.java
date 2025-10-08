class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] order = new int[spells.length];
        for(int i = 0; i < order.length; i++) order[i] = spells[i];
        Arrays.sort(spells);
        Arrays.sort(potions);
        Map<Integer,Integer> possibleCount = new HashMap<>();
        

        int i = 0;
        int j = potions.length - 1;
        int possiblePairs = 0;
        int totalPairs = 0;
        while(i < spells.length){
            while(j >= 0 && (long)spells[i] * potions[j] >= success){
                possiblePairs++;
                j--;
            }
            possibleCount.put(spells[i] , possiblePairs);
            i++;
        }
        int[] result = new int[spells.length];
        for(int t = 0;  t < result.length; t++){
            result[t] = possibleCount.get(order[t]);
        }
        return result;
       
    }
}