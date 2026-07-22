class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                l++;
                r--;
                count++;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}