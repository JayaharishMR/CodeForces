class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm1 = new HashMap<>();
        for (int i : nums1) {
            hm1.put(i, 1);
        }
        Set<Integer> seen = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            if (!hm1.containsKey(i)) {
                set2.add(i);
            } else {
                seen.add(i);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            if (!seen.contains(i)) {
                set.add(i);
            }
        }
        List<Integer> arr1 = new ArrayList<>(set);
         List<Integer> arr2 = new ArrayList<>(set2);
        List<List<Integer>> res = new ArrayList<>();
        res.add(arr1);
        res.add(arr2);
        return res;
    }
}