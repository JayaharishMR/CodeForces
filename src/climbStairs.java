import java.util.Arrays;

public class climbStairs {
    public int helperFun(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = helperFun(n-1, dp) + helperFun(n-2, dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helperFun(n, dp);
    }
    public static void main(String[] args) {
        climbStairs climbStairs = new climbStairs();
        System.out.println(climbStairs.climbStairs(3));
    }
}
