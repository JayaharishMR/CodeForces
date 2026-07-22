class Solution {
    public boolean isSubsequence(String s, String t) {
        int l = 0;
        int r = 0;
        if (s.length() == 0) return true;
        if (t.length() < s.length()) return false;

        while (r < t.length()) {
            if (t.charAt(r) == s.charAt(l)) {
                l++;
            }
            if (l >= s.length()) return true;
            r++;
        }
        return false;
        
    }
}