class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = Math.abs(arr[0]-arr[1]);
        //System.out.println(diff);
        for (int i = 2; i < arr.length; i++) {
            //System.out.println(arr[i]+" , "+arr[i-1]);
            int a = arr[i];
            int diff1 = Math.abs(a - arr[i-1]);
            //System.out.println(diff1);
            if (diff1 != diff) {
                return false;
            }
        }
        return true;
    }
}