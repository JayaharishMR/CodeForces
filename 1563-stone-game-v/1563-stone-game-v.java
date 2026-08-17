import java.util.Arrays;

class Solution {

    int[][] dp;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i - 1];
        }

        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxValue(
                calculateTotal(prefixSum, 0, n),
                0,
                n,
                prefixSum
        );
    }

    public int calculateTotal(int[] prefixSumArr, int l, int r) {
        return prefixSumArr[r] - prefixSumArr[l];
    }

    public int maxValue(
            int total,
            int l,
            int r,
            int[] prefixSumArr) {

        // Only one stone -> cannot score anything
        if (r - l <= 1) {
            return 0;
        }

        // Already calculated
        if (dp[l][r - 1] != -1) {
            return dp[l][r - 1];
        }

        int max = 0;

        // Try every possible split
        for (int i = l + 1; i < r; i++) {

            int leftSum =
                    calculateTotal(prefixSumArr, l, i);

            int rightSum =
                    calculateTotal(prefixSumArr, i, r);

            if (leftSum < rightSum) {

                int candidate =
                        leftSum +
                        maxValue(
                                leftSum,
                                l,
                                i,
                                prefixSumArr
                        );

                max = Math.max(max, candidate);

            } else if (rightSum < leftSum) {

                int candidate =
                        rightSum +
                        maxValue(
                                rightSum,
                                i,
                                r,
                                prefixSumArr
                        );

                max = Math.max(max, candidate);

            } else {

                int leftCandidate =
                        leftSum +
                        maxValue(
                                leftSum,
                                l,
                                i,
                                prefixSumArr
                        );

                int rightCandidate =
                        rightSum +
                        maxValue(
                                rightSum,
                                i,
                                r,
                                prefixSumArr
                        );

                max = Math.max(
                        max,
                        Math.max(
                                leftCandidate,
                                rightCandidate
                        )
                );
            }
        }

        dp[l][r - 1] = max;

        return max;
    }
}