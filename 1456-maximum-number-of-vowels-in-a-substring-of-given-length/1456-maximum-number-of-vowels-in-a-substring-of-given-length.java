class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int max = 0;
        if (s.length() < k) return 0;
        for(int i =0; i < k; i++) {
            res += isVowel(s.charAt(i));
        }
        max = res;
        int r = k;
        while (r < s.length()) {
            res += isVowel(s.charAt(r)) - isVowel(s.charAt(r-k));
            r++;
            max = Math.max(max, res);
        }
        return max;
    }

    public int isVowel(char c) {
        String vowel = "aeiou";
        return (vowel.contains(String.valueOf(c))) ? 1 : 0;
    }
}