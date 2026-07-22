class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int zeros = 0;
        int max = 0;
        while (r < nums.length && l <= r) {
            if (nums[r] == 0) {
                zeros++;
            } 
            if (zeros > k) {
                while (l <= r && nums[l] != 0) {
                    l++;
                }
                l++;
                zeros--;
            }
            max = Math.max(max, r+1-l);
            //System.out.println(r+ " "+l+ " "+max+" "+zeros);
            r++;
        }
        return max;
    }
}