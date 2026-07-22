class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            int diff = k - i;
            int freq = hm.get(diff) != null ? hm.get(diff) : 0;
            if (freq > 0) {
                hm.put(diff, freq-1);
                count++;
            } else {
                hm.put(i, hm.getOrDefault(i,0)+1);
            }
        }
        return count;
    }
}