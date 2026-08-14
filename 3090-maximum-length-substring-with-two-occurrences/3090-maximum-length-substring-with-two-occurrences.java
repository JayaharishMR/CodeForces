class Solution {
    public int maximumLengthSubstring(String s) {
        int l =0;
        int r =0;
        int max = 0;
        Map<Character, Integer> hm = new HashMap<>();
        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r),0)+1);
            while(hm.get(s.charAt(r)) > 2) {
                hm.put(s.charAt(l), hm.get(s.charAt(l))-1);
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}