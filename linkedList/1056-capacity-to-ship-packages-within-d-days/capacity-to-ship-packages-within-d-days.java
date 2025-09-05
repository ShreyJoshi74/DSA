class Solution {
    public int findRequiredDays(int[] weights, int minWeight){
        int day = 1;
        int currentWeight = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + currentWeight > minWeight){
                day++;
                currentWeight = weights[i];
            } else {
                currentWeight += weights[i];
            }
        }
        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, h = 0, ans = -1;
        for(int i = 0; i < weights.length; i++) {
            l = Math.max(l, weights[i]); // min capacity = max weight
            h += weights[i];            // max capacity = total sum
        }

        while(l <= h){   // ✅ use while instead of for loop
            int mid = (l + h) / 2;
            int requiredDays = findRequiredDays(weights, mid);
            System.out.println(requiredDays);

            if(requiredDays <= days){
                ans = mid;
                h = mid - 1; // try smaller capacity
            } else {
                l = mid + 1; // need bigger capacity
            }
        }
        return ans;
    }
}
