class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] max = new int[nums.length];
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            max[i] = mx;
        }
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            int sIdx = max[i]-min;
            if (sIdx <= k ) {
                res = i;
            }
        }
        return res;
    }
}