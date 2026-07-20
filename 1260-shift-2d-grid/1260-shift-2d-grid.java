class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int m = grid.length;
    int n = grid[0].length;
    int len = m * n;

    k %= len;

    int[][] ans = new int[m][n];

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int index = i * n + j;
            int newIndex = (index + k) % len;

            int x = newIndex / n;
            int y = newIndex % n;

            ans[x][y] = grid[i][j];
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int[] row : ans) {
        List<Integer> list = new ArrayList<>();
        for (int val : row) {
            list.add(val);
        }
        res.add(list);
    }

    return res;
}
}