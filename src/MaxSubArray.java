public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {1};
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
