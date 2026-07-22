class Solution {
    public int longestSubarray(int[] nums) {
        int zeros = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            } 
            if (zeros > 1) {
                while (l < r && nums[l] != 0) {
                    l++;
                }
                l++;
                zeros--;
            }
            max = Math.max(max, r+1-l);
            r++;
        }
        return max-1;
    }
}