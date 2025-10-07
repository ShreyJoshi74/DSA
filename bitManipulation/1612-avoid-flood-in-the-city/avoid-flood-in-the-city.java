class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> nextRainDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        Set<Integer> fullLakes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                res[i] = 1; // default (in case no lake needs drying)
            } else {
                int lake = rains[i];
                if (fullLakes.contains(lake)) {
                    Integer dryDay = dryDays.higher(nextRainDay.get(lake));
                    if (dryDay == null) return new int[] {}; // flood
                    res[dryDay] = lake; // dry this lake
                    dryDays.remove(dryDay);
                }
                fullLakes.add(lake);
                res[i] = -1;
                nextRainDay.put(lake, i);
            }
        }
        return res;
    }
}
