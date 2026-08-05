class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            arr[i] = 1; 
        }
        

        for (int i = 0; i < invocations.length; i++) {
            int a = invocations[i][0];
            int b = invocations[i][1];

            graph.get(a).add(b);
        }

        boolean[] visited = new boolean[n];
        
        dfs(graph, arr, visited, k, 0);
        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];

            // non-suspicious method calls suspicious method
            if (arr[from] == 1 && arr[to] == 0) {
               List<Integer> res = new ArrayList<>();
               for (int i = 0; i < n; i++) {
                    res.add(i);
                }
            return res;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i =0; i < n; i++) {
            if (arr[i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public void dfs(List<List<Integer>> graph, int[] arr, boolean[] visited, int curr, int flag) {
        arr[curr] = flag;
        //System.out.println("Marking "+curr+" as "+flag);
        if (visited[curr]) {
            //System.out.println("Marking "+curr+" as "+flag+ " no neighbour");
            return;
        }
        visited[curr] = true;
        for (int neighbour : graph.get(curr)) {
            //System.out.println("neighbour is "+ neighbour);
            dfs(graph, arr, visited, neighbour, flag);
        }
    }
}