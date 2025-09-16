import java.util.Arrays;

public class twoPointSorter {
    public static void sorter(int[] nums) {
        int i =0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 0) {
                i++;
            } else if (nums[j] == 1) {
                j--;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }

    public static void sorter2(int[] nums) {
        int i =0;
        int j = 0;
        int k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
               int temp = nums[j];
               nums[j] = nums[i];
               nums[i] = temp;
               i++;
               j++;
            } else if (nums[j] == 1) {
                j++;
            } else {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sorter3(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int l = nums.length - 1;

        /*
        0 - i-1 = 0;
        i - j-1 = 1;
        j - k-1 = 2;
        k - l-1 = unsorted;
        l - n-1 = 3
         */

        while (k<=l) {
            if (nums[k] == 0) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;

                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                i++;
                j++;
                k++;
            } else if (nums[k] == 1) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                j++;
                k++;
            } else if (nums[k] == 2) {
               k++;
            } else {
                int temp = nums[k];
                nums[k] = nums[l];
                nums[l] = temp;
                l--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        sorter(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0};
        sorter2(nums2);
        int[] nums3 = {0, 3, 0, 1, 2, 0, 1, 3, 2, 0, 3, 1, 3, 2, 3, 1, 3, 2, 3, 1, 3, 2, 3, 1, 3, 2, 3};
        sorter3(nums3);
    }
}
