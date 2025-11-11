import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> hm = new HashMap<>();

        hm.put(0,1);

        int sum = 0;
        int prefix = 0;
        int count = 0;
        for(int num : nums) {

            sum += num;
            prefix = sum - k;

            count += hm.getOrDefault(prefix, 0);
            hm.put(sum, hm.getOrDefault(sum, 0 ) + 1);


        }

        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int[] arr = new int[] {2,1,2,1,1,2};
        int k = 3;
        System.out.println(subArraySum.subarraySum(arr, k));
    }
}

