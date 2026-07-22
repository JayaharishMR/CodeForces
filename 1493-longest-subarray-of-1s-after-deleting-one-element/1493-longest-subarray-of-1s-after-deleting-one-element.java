class Solution {
    public int longestSubarray(int[] nums) {
        int ones = 0;
        int zeros = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            } else {
                ones++;
            }
            if (zeros > 1) {
                while (l < r && nums[l] != 0) {
                    l++;
                    ones--;
                }
                l++;
                zeros--;
            }
            max = Math.max(max, ones);
            r++;
        }
        return max == nums.length ? max-1 : max;
    }
}