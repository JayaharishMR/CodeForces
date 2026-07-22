class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0.00;
        int sum = 0;
        for (int i =0; i < k ; i++) {
            sum += nums[i];
        }
        int l = 0;
        int r = k;
        int max = sum;
        while (r < nums.length) {
            sum -= nums[l];
            sum += nums[r];
            l++;
            r++;
            max = Math.max(max, sum);
        }

        return (double) max/k;
    }
}