class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k == 0) return;

        rotate(nums, 0, n, k);
    }

    private void rotate(int[] nums, int start, int len, int k) {
        if (k == 0 || k == len) return;

        int left = len - k;
        int right = k;

        if (left == right) {
            swap(nums, start, start + left, left);
            return;
        }

        if (left > right) {
            // Swap last 'right' elements of left block
            swap(nums, start + left - right, start + left, right);

            // Solve remaining left block
            rotate(nums, start, left, k);
        } else {
            // Swap first 'left' elements of right block
            swap(nums, start, start + left, left);

            // Solve remaining right block
            rotate(nums, start + left, right, k - left);
        }
    }

    private void swap(int[] nums, int i, int j, int len) {
        for (int x = 0; x < len; x++) {
            int temp = nums[i + x];
            nums[i + x] = nums[j + x];
            nums[j + x] = temp;
        }
    }
}