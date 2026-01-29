


class Solution {
    static final long INF = (long)1e18;
    Map<Integer,long[]> computed = new HashMap<>();

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        Map<Integer,List<int[]>> edges = new HashMap<>();
        for(int i = 0; i < 26; i++)
            edges.put(i,new ArrayList<>());

        for(int i = 0; i < original.length; i++){
            int src = original[i] - 'a';
            int tar = changed[i] - 'a';
            edges.get(src).add(new int[]{tar, cost[i]});
        }

        long totalCost = 0;

        for(int i = 0; i < source.length(); i++){
            long val = findCost(source.charAt(i), target.charAt(i), edges);
            if (val >= INF) return -1;   // unreachable case
            totalCost += val;
        }

        return totalCost;
    }

    private long findCost(char src, char tar, Map<Integer,List<int[]>> edges){

        if(src == tar) return 0;

        if(computed.containsKey(src - 'a'))
            return computed.get(src - 'a')[tar - 'a'];

        long[] dis = new long[26];
        Arrays.fill(dis, INF);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));

        dis[src - 'a'] = 0;
        pq.add(new long[]{src - 'a', 0});

        while(!pq.isEmpty()){
            long[] temp = pq.poll();
            int node = (int) temp[0];
            long curr = temp[1];

            if(curr > dis[node]) continue;

            for(int[] next : edges.get(node)){
                int nextNode = next[0];
                int c = next[1];

                if(curr + c < dis[nextNode]){
                    dis[nextNode] = curr + c;
                    pq.offer(new long[]{nextNode, dis[nextNode]});
                }
            }
        }

        computed.put(src - 'a', dis);
        return dis[tar - 'a'];
    }
}
