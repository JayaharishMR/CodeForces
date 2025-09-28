import java.util.Map;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSumMethod(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (hm.containsKey(rem)) {
                return new int[] {hm.get(rem), i};
            }
            hm.put(nums[i], i);
        }
        return null;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        twoSumMethod(nums, target);
    }
}


