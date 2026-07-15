class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        if (n ==5) return 7;
        if (n == 6) return 13;
        if (n == 7) return 24;
        if (n == 8) return 44;
        return tribonacci(n-3)+tribonacci(n-2)+tribonacci(n-1);
    }

    // public void helper(int[] dp, int n) {
    //     int i = 3;
    //     while (i <=n) {
    //         dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    //     }
    // }
}