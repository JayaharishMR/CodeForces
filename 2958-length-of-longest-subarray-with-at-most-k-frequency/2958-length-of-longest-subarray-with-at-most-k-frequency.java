class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> hm = new HashMap<>();
        int l =0;
        int r =0;
        int maxLength = 0;
        while (r < nums.length) {
            hm.put(nums[r], hm.getOrDefault(nums[r],0)+1);
            if (hm.get(nums[r]) > k) {
                while (nums[l] != nums[r]) {
                    hm.put(nums[l], hm.get(nums[l])-1);
                    l++;
                }
                hm.put(nums[l], hm.get(nums[l])-1);
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        return maxLength;
    }
}