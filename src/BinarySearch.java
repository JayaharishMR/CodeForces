public class BinarySearch {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while (s<=e) {
            int m = (s+e)/2;
            int mn = nums[m];
            if (target == mn) return m;
            if (target > mn) {
                s = m+1;
            } else {
                e = m-1;
            }
        }
        return -1;
    }
}
