class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int numOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            if (nums[i] == 0) numOfZeros++;
        }
        if (xor != 0) {
            return nums.length;
        } else if (nums.length == numOfZeros) {
            return 0;
        }
        return nums.length-1;
    }
}