public class ContainerWithMostWater {
    public static int maxmimumWater(int[] height) {
        int maxWater = 0;
        int l = 0;
        int r = height.length-1;
        while (l < r) {
            int currWater = Math.min(height[l], height[r]) * (r-l);
            maxWater = Math.max(currWater, maxWater);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxmimumWater(height));
    }
}
