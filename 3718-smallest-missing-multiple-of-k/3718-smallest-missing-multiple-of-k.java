class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] arr = new int[101];
        for (int i : nums) {
            arr[i] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            int num = k*i;
            if (num > 101){
                return num;
            } else if (arr[num] == 0) {
                return num;
            }
        }
        return k*(nums.length+1);
    }
}