public class NextGreaterElement {
    public static int nextGreaterElement(int n) {
            char[] nums = String.valueOf(n).toCharArray();
            int i;
            for (i = nums.length - 1; i > 0; i--) {
                if (nums[i-1] < nums[i]) {
                    break;
                }
            }
            if (i == 0) {
                return -1;
            }
            int smallest = i;
            int x = nums[i-1];
            for (int j = i+1; j<nums.length; j++) {
                if (nums[j] > x && nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }

            char temp = nums[i-1];
            nums[i-1] = nums[smallest];
            nums[smallest] = temp;

            for (int k = i ; k < nums.length; k++) {
                 for (int l = i; l < nums.length-1; l++) {
                     if (nums[l] > nums[l+1]) {
                         temp = nums[l+1];
                         nums[l+1] = nums[l];
                         nums[l] = temp;
                     }
                 }
            }
            long val = Long.parseLong(String.valueOf(nums));
            return val > Integer.MAX_VALUE ? -1 : (int) val;
    }
    public static void main(String[] args) {
        int nums = 230241;
        System.out.println(nextGreaterElement(nums));
    }
}
