class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = nums[0];
        int numOfZeros = nums[0] == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
            if (nums[i] == 0) numOfZeros++;
        }
        if (xor == 0) {
            if (numOfZeros == nums.length) {
                return 0;
            }
            return nums.length-1;
        }
        return nums.length;
    }
}