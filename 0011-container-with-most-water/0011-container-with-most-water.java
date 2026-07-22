class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length -1;
        if (height.length <= 1) return max;
        while (l < r) {
            if (height[l] > height[r]) {
                max = Math.max(max, height[r]*(r-l));
                r--;
            } else {
                max = Math.max(max, height[l]*(r-l));
                l++;
            }
        }
        return max;
    }
}