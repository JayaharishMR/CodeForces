public class FindMedianTwoSortedArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
                k++;
            } else {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        double median = 0;
        if ((m+n) % 2 == 0) {
            median = (nums[(m+n)/2] + nums[(m+n)/2 - 1]) / 2.0;
        } else {
            median = nums[(m+n)/2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
