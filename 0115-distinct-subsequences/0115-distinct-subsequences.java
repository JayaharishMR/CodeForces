class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m<n) {
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            dp[i][0]=1;
        }
         for (int i = 1; i <= m; i++) {
            char sChar = s.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char tChar = t.charAt(j-1);
                if (sChar == tChar) {
                    dp[i][j] = dp[i-1][j-1]+ dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}