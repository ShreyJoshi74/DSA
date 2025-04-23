class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[40]; // Max sum of digits for n <= 10^4 is < 36
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int sum = sumDigits(i);
            count[sum]++;
            maxSize = Math.max(maxSize, count[sum]);
        }

        int res = 0;
        for (int c : count) {
            if (c == maxSize) res++;
        }

        return res;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
