import java.util.Arrays;

public class squaresOfSortedArray {
    public static void bubbleSort(int[] nums) {
        boolean swapped = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (Math.abs(nums[j]) > Math.abs(nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
       for (int i = 0 ; i < nums.length; i++) {
           nums[i] = nums[i]*nums[i];
       }
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int ele = nums[i];
            int j = i-1;
            while (j >= 0 && Math.abs(nums[j]) > Math.abs(ele)) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = ele;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void squaresOfSortedArrayMethod(int[] nums) {
        int l=0;
        int r = nums.length-1;
        int[] ans = new int[nums.length];
        int k = nums.length-1;
        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                ans[k] = nums[l]*nums[l];
                l++;
            } else {
                ans[k] = nums[r]*nums[r];
                r--;
            }
            k--;
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void main(String[] args) {
        int[] nums = {-3,-2,7,8,9};
        squaresOfSortedArrayMethod(nums);
    }
}
