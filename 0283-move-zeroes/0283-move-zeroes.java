class Solution {
    public void moveZeroes(int[] nums) {
        //saw a solution called snowball and it is good
        int snowBall = 0;
        for (int i  = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBall++;
            } else {
                if (snowBall  == 0) continue;
                int temp = nums[i];
                nums[i] = 0;
                nums[i - snowBall] = temp; 
            }
        }
    }
}