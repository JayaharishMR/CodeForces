public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int[] nest = new int[nums.length];
        for (int i : nums) {
            if (nest[i] == 1) {
                return i;
            }
            nest[i] = 1;
        }
        return 0;
    }
}