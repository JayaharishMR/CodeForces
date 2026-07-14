class Solution {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        return helper(n, arr);
    }

    public int helper(int n, int[] arr) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 3;
        while (a <= n) {
            arr[a] = arr[a-1]+arr[a-2];
            a++;
        }
        return arr[n];
    }

}