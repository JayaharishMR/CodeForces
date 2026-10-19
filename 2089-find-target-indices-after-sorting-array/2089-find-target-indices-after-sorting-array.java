class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int l = 0;
        int rep = 0;
        for (int i : nums) {
            if (i < target) l++;
            if (i == target) rep++;
        }
        int startingIndex = l;
        List<Integer> res = new ArrayList<>();
        for (int i =0; i < rep; i++) {
            res.add(startingIndex++);
        }
        return res;
    }
}