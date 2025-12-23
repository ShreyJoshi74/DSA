import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Min-heap by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]   // endTime
        );

        int bestSoFar = 0;
        int ans = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            // Remove all non-overlapping previous events
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                bestSoFar = Math.max(bestSoFar, pq.poll()[1]);
            }

            // Combine current event with best previous
            ans = Math.max(ans, bestSoFar + value);

            // Also consider taking only this event
            ans = Math.max(ans, value);

            // Add current event to heap
            pq.offer(new int[]{end, value});
        }

        return ans;
    }
}
