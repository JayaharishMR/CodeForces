class Solution {
    public boolean res = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1 || edges.length == 0) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, source, visited, destination);
        return res;
    }

    public void dfs(List<List<Integer>> graph, int curr, boolean[] visited, int destination) {
        if (visited[curr] || res) return ;

        for (int neighbour : graph.get(curr)) {
            if (neighbour == destination) {
                res = true;
                return;
            }
            visited[curr] = true;
            dfs(graph, neighbour, visited, destination);
        }
    }
}