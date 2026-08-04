class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max  = Integer.MIN_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        int[] arr = new int[(max-min)+1];

        for (int i :  nums) {
            arr[i-min] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                res.add(i+min);
            }
        }
        return res;
    }
}