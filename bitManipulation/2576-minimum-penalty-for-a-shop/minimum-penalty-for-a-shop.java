class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        int totalN = 0;
        int n = customers.length();
        for(int i = 0; i < n; i++){
            if(customers.charAt(i) == 'Y') totalY++;
            if(customers.charAt(i) == 'N') totalN++;
        }
        int currentY = 0;
        int currentN = 0;
        int minPenalty = Integer.MAX_VALUE;
        int atIndex = -1;
        
        // check from index 0 to n-1
        for(int i = 0; i < n; i++){
            int penalty = (totalY - currentY) + currentN;
            if(customers.charAt(i) == 'Y') currentY++;
            if(customers.charAt(i) == 'N') currentN++;
            if(penalty < minPenalty){
                atIndex = i;
                minPenalty = penalty;
            }
        }
        // check at last index
        int penalty = totalY - currentY + currentN;
        if(penalty < minPenalty) atIndex = n; 
        return atIndex;
    }
}