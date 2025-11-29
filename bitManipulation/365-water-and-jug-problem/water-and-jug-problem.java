class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public boolean canMeasureWater(int x, int y, int target) {
        if (target == 0) return true;
        if (x + y < target) return false;
        if (x == 0 || y == 0) return target == x || target == y;

        return target % gcd(x, y) == 0;
    }
}
