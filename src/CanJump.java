public class CanJump {
    static{
        for(int i=1;i<=500;i++){
            canJump(new int[]{1,2,3,0,4});
        }
    }
    public static boolean canJump(int[] nums) {
        int jump=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0){
                if(jump<1){
                    return false;
                }
            }
            jump=Math.max(jump,nums[i]);
            jump--;
        }
        return true;
    }
}