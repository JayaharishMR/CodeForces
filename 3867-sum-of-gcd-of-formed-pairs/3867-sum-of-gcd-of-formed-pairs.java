class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int [] prefixGcd = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i],max);
        }
        Arrays.sort(prefixGcd);
        int l = 0;
        int r = n-1;
        long res = 0;
        while (l < r) {
            res += gcd(prefixGcd[l], prefixGcd[r]);
            l++;
            r--;
        }
        return res;
        
    }

    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}