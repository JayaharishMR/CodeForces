import java.util.*;

public class anagram {
    public boolean isAnagram(String s, String t) {
        int slength = s.length();
        int tlength = t.length();
        if (slength != tlength) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < slength; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        anagram anagram = new anagram();
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
    }
}
