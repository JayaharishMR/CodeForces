class Solution {
    public int numDecodings(String s) {
        Set<String> validArr = new HashSet<>();
        for(int i = 1; i <= 26; i++) {
            validArr.add(String.valueOf(i));
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = validArr.contains(String.valueOf(s.charAt(n-1))) ? 1 : 0;
        for (int i = n-2; i >=0; i--) {
            String a = String.valueOf(s.charAt(i));
            String b = String.valueOf(s.charAt(i+1));
            if (a.equals("0")){
                dp[i] = 0;
                continue;
            }
            //choice 1
            if (validArr.contains(a)) {
                dp[i] = dp[i+1];
            }

            //choice 2
            if (validArr.contains(a+b)) {
                dp[i] = dp[i+1] + dp[i+2];

            }
        }
        return dp[0];
    }
}