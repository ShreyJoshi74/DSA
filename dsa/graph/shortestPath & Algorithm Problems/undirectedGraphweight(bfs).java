class Pair {
    int vertex;
    int weight;

    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}

class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int tVertex = adj.size();
        int[] dis = new int[tVertex];
        boolean[] visited = new boolean[tVertex];

        Arrays.fill(dis, -1); // mark all distances as unreachable initially

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dis[src] = 0;
        visited[src] = true;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int u = current.vertex;
            int dist = current.weight;

            for (Integer neighbor : adj.get(u)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dis[neighbor] = dist + 1;
                    q.add(new Pair(neighbor, dist + 1));
                }
            }
        }

        return dis;
    }
}
