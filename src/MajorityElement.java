import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majority = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (map.containsKey(currNum)) {
                map.put(currNum, map.get(currNum) + 1);
            } else {
                map.put(currNum, 1);
            }
            if (map.get(currNum) > majority) {
                majority = map.get(currNum);
                result = currNum;
            }
        }
        return result;
    }

    public static int majorityElement2(int[] nums) {
        int res = 0;
        int majority = 0;
        for (int n : nums) {
            if (majority == 0) {
                res = n;
            }
            majority = (n==res) ? ++majority : --majority;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,4};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
    }
}
