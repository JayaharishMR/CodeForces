import java.util.ArrayList;
import java.util.List;

public class Permute {
    public static void helper(int[] nums, List<List<Integer>> ans, int start) {
        if (start == nums.length) {
            List<Integer> al = new ArrayList<>();
            for (int x : nums) {
                al.add(x);
            }
            ans.add(al);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(nums, ans, start + 1);
            swap(nums, i, start);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, 0);
        return ans;
    }

    public static void main(String[] args) {
        Permute permuteVar = new Permute();
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> ans = permuteVar.permute(nums);
        for(List<Integer> arr:ans) {
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
