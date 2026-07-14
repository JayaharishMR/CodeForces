class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) {
            return cost[0];
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] arr = new int[n+1];
        arr[n] = 0;
        arr[n-1] = cost[n-1];
        arr[n-2] = cost[n-2];
        return helper(cost, arr, n-3);
    }

    public int helper(int[] cost, int[] dp, int n) {
        while (n >=0 ) {
            dp[n] = cost[n] + Math.min(dp[n+1], dp[n+2]);
            n--;
        }
        return Math.min(dp[0],dp[1]);
    }

    
}