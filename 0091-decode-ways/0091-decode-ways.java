class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = !String.valueOf(s.charAt(n-1)).equals("0") ? 1 : 0;
        for (int i = n-2; i >=0; i--) {
            String a = String.valueOf(s.charAt(i));
            if (a.equals("0")){
                dp[i] = 0;
                continue;
            }
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
             //choice 2
            if (num >= 10 && num <= 26) {
                dp[i] = dp[i+1] + dp[i+2];
                continue;
            }
            //choice 1
            dp[i] = dp[i+1];
           
        }
        return dp[0];
    }
}