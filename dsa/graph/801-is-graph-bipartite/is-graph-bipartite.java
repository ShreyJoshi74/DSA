class Solution {
    public boolean isBipartite(int[][] graph) {
        char[] color = new char[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = 'N';  // N = Not colored
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 'N') {
                if (!dfs(i, graph, color, 'G')) {  // Start with color G
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[][] graph, char[] color, char currentColor) {
        if (color[node] != 'N') {
            return color[node] == currentColor;
        }

        color[node] = currentColor;
        char oppositeColor = currentColor == 'G' ? 'Y' : 'G';

        for (int neighbor : graph[node]) {
            if (!dfs(neighbor, graph, color, oppositeColor)) {
                return false;
            }
        }
        return true;
    }
}