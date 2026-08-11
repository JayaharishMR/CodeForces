class Solution {
    public int missingInteger(int[] nums) {
        if (nums.length == 1) {
            return nums[0]+1;
        }
        int[] arr = new int[50];
        int finalSum = nums[0];
        arr[nums[0]-1] = 1;
        boolean found = false;
        for (int i =1; i < nums.length; i++) {
            arr[nums[i]-1] = 1;
           if (nums[i] - nums[i-1] == 1 && !found){
            finalSum += nums[i];
           } else {
            found = true;
           }
        }
        if (finalSum > 50) {
            return finalSum;
        }
        for (int i = finalSum-1; i < arr.length; i++) {
            if (arr[i] != 1) {
                return i+1;
            }
        }
        return 51;
    }
}