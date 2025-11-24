public class WaterTrapProblem {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        prefixMax[0] = height[0];
        for (int i = 1;i < height.length; i++) {
            prefixMax[i] = Math.max(height[i], prefixMax[i-1]);
        }
        suffixMax[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i>=0; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i+1]);
        }
        int water = 0;
        for (int i =0; i<height.length; i++) {
           int w = Math.min(prefixMax[i], suffixMax[i]) - height[i];
           if (w > 0) {
               water += w;
           }
        }
        return water;
    }

    public static void main(String[] args) {
        WaterTrapProblem waterTrapProblem = new WaterTrapProblem();
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(waterTrapProblem.trap(height));
    }
}
