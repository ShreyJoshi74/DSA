class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // room, freeTime
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        int[] rooms = new int[n];

        for (int i = 0; i < n; i++) {
            pq.add(new long[]{i, 0L});
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            long startTime = meeting[0];
            long duration = meeting[1] - meeting[0];

            if (pq.peek()[1] > startTime) {
                long[] temp = pq.poll();
                pq.add(new long[]{temp[0], temp[1] + duration});
                rooms[(int) temp[0]]++;
            } else {
                List<long[]> ls = new ArrayList<>();
                long room = Long.MAX_VALUE;

                while (!pq.isEmpty() && startTime >= pq.peek()[1]) {
                    room = Math.min(pq.peek()[0], room);
                    ls.add(pq.poll());
                }

                rooms[(int) room]++;

                for (long[] r : ls) {
                    if (r[0] == room) {
                        pq.add(new long[]{room, startTime + duration});
                    } else {
                        pq.add(r);
                    }
                }
            }
        }

        int mostUsedRoom = 0;
        int cnt = -1;

        for (int i = 0; i < n; i++) {
            if (rooms[i] > cnt) {
                cnt = rooms[i];
                mostUsedRoom = i;
            }
        }

        return mostUsedRoom;
    }
}
