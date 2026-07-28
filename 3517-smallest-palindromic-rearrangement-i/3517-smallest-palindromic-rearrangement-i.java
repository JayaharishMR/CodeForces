class Solution {
    public String smallestPalindrome(String s) {
        int len = s.length();
        if (len <= 2) return s;
        StringBuilder sb = new StringBuilder(s);

        if (len % 2 == 0) {
            return lexiographicString(s.substring(0,len/2), '1');
        } else {
            return lexiographicString(s.substring(0, len/2), s.charAt(len/2));
        }
    }

    public String lexiographicString(String s, char middle) {
        int[] alphaArr = new int[26];
        for (int i =0; i < s.length(); i++) {
            alphaArr[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (alphaArr[i]-- != 0) {
                sb.append((char) (i+'a'));
            }
        }
       // System.out.println(s + " "+sb.toString());
        StringBuilder reverse;
        reverse = new StringBuilder(sb);
        reverse.reverse();
        if (middle != '1') {
           // System.out.println(sb.toString()+" "+String.valueOf(middle)+" "+reverse.toString());
            return sb.toString()+String.valueOf(middle)+reverse.toString();
        }
        return sb.toString()+reverse.toString();
    }
}