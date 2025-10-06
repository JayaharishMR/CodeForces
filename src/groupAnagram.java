import java.util.*;

public class groupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        groupAnagram groupAnagram = new groupAnagram();
        System.out.println(groupAnagram.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }
}
