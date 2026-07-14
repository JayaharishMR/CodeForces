class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        return fib(n, arr);
    }

    public int fib(int n, int[] arr) {
        if (n == 0) return 0;
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fib(n-1, arr)+fib(n-2,arr);
        return arr[n];
    }
}