public class ProductArrayExceptSelf {
    static{
        for(int i=0;i<500;i++){
            productExceptSelf(new int[]{1,2});
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int prefix = 1;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = prefix;
            prefix*=nums[i];
        }

        int postfix = 1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=postfix;
            postfix*=nums[i];
        }

        return ans;
    }
}