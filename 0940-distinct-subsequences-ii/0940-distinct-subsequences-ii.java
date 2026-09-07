class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int MOD = (int) 1e9+7;

        int[] countEndWith = new int[26];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            int curr = (int) (1L + sum - countEndWith[idx]+ MOD)% MOD;
            sum = (sum + curr) % MOD;
            countEndWith[idx] = (countEndWith[idx]+curr)%MOD;
        }
        return sum;
    }
}