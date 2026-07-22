class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int max = 0;
        if (s.length() < k) return 0;
        for(int i =0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                res++;
            }
        }
        max = res;
        int l = 0;
        int r = k;
        while (r < s.length()) {
            res -= isVowel(s.charAt(l)) ? 1 : 0;
            res += isVowel(s.charAt(r)) ? 1 : 0;
            l++;
            r++;
            max = Math.max(max, res);
        }
        return max;
    }

    public boolean isVowel(char c) {
        String vowel = "aeiou";
        return (vowel.contains(String.valueOf(c)));
    }
}