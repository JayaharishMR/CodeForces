import java.util.Arrays;

public class RemoveDuplicates {
        public int removeDuplicates(int[] nums) {
            int l=0 , r =0;
            while (r < nums.length) {
                if (nums[l] != nums[r]) {
                    l++;
                    nums[l] = nums[r];
                }
                r++;
            }
            return l+1;
        }
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
