class Solution {
    int min = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
       List<List<int[]>> graph = new ArrayList<>();
       for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
       }
       for (int[] road : roads) {
        int a = road[0];
        int b = road[1];
        int c = road[2];

        graph.get(a).add(new int[]{b,c});
        graph.get(b).add(new int[]{a,c});
       }
       boolean[] visited = new boolean[n+1];
       dfs(1, graph, visited);
       return min;
    }

    public void dfs(int node, List<List<int[]>> graph, boolean[] vis) {
        vis[node] = true;

        for (int[] neighbour : graph.get(node)) {
            int next = neighbour[0];
            int dist = neighbour[1];

            min = Math.min(min, dist);
            if (!vis[next]) {
                dfs(next, graph, vis);
            }
        }
    }
}