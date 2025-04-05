class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int a) {
        v = a;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        // Step 1: Add beginWord at start
        wordList.add(0, beginWord);
        int n = wordList.size();

        // Step 2: Build graph
        Graph g = new Graph(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (checkDifference(wordList.get(i), wordList.get(j))) {
                    g.adj.get(i).add(j);
                    g.adj.get(j).add(i);
                }
            }
        }

        // Step 3: BFS
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>(); // [index, steps]
        q.add(new int[]{0, 1});
        visited[0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int idx = curr[0];
            int steps = curr[1];

            if (wordList.get(idx).equals(endWord)) {
                return steps;
            }

            for (int neighbor : g.adj.get(idx)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new int[]{neighbor, steps + 1});
                }
            }
        }

        return 0; // No path found
    }

    public boolean checkDifference(String s, String p) {
        int count = 0;
        if (s.length() != p.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i)) {
                count++;
                if (count > 1) return false;
            }
        }
        return count == 1;
    }
}
