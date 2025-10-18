public class RotatedSortedArray {
    public int searchInRsa(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int m = 0;
        while (s <= e) {
             m = (s+e)/2;
             int se = nums[s];
            int me = nums[m];
            int ee = nums[e];
            if (me == target) return m;
            if (se <= me) {
                if (target >= se && target <=  me) {
                    e = m-1;
                } else {
                    s=m+1;
                }
            } else {
                if (target >= me && target <=ee) {
                    s = m+1;
                } else {
                    e =m-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArray rotatedSortedArray =new RotatedSortedArray();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotatedSortedArray.searchInRsa(nums, target));
    }
}
