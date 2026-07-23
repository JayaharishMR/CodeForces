class Solution {
    public int pivotIndex(int[] nums) {
        int[] ps = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            ps[i+1] = ps[i]+nums[i];
        }

        for(int i =0; i < ps.length-1; i++) {
            if ((ps[ps.length-1]-ps[i]-(ps[i+1]-ps[i])) == ps[i]) {
                return i;
            }
        }
        return -1;
    }
}