class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length -1;
        if (height.length <= 1) return max;
        while (l < r) {
            int min = Math.min(height[r], height[l]);
            max = Math.max(max, min*(r-l));
            while (l < r && height[l] <= min) {
                l++;
            }
            while (l < r && height[r] <= min) {
                r--;
            }
        }
        return max;
    }
}