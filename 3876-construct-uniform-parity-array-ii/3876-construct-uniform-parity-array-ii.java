class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int first = nums1[0];
        if (first%2 == 0) {
            return evenHelper(nums1);
        } else {
            return oddHelper(nums1);
        }
    }

    public boolean evenHelper(int[] nums) {
        int first = nums[0];
        for (int i : nums) {
            if (i%2 == 0 || (i-first >=1 && i-first%2 == 0)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
     public boolean oddHelper(int[] nums) {
        int first = nums[0];
        for (int i : nums) {
            if (i%2 != 0 || (i-first >=1 && i-first%2 != 0)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}