public class quickSort {
    public static void main(String[] args) {
        quickSort quickSort = new quickSort();
        int[] nums = {9,13,11,6,8,7};
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pe = nums[high];
        int pi = partition(nums, low, high, pe);
        quickSort(nums, low, pi - 1);
        quickSort(nums, pi + 1, high);

    }

    public static int partition(int[] nums, int low, int high, int pe) {
        int i =low;
        int j=low;
        while (i <= high) {
            if (nums[i] <= pe) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j-1;
    }
}
