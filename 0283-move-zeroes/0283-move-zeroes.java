class Solution {
    public void moveZeroes(int[] nums) {
        int l =0;
        int r =0;
        if (nums.length <= 1) {
            return;
        }
        while (r < nums.length) {
            if (nums[l] == 0) {
                while (r <  nums.length && nums[r] == 0) {
                    r++;
                }
                swap(nums, l, r);
                l++;
            } else {
                l++;
                r++;
            }
        }
    }

    public void swap(int[] nums, int l, int r) {
        if (r >= nums.length) return;
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}