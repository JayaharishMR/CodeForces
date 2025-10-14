import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return isValid(s, new HashMap<>(), wordDict);
    }
    public boolean isValid(String s, Map<String, Boolean> map, List<String> dicitonary){
        if (s.isEmpty()) return true;
        if (map.containsKey(s)) return map.get(s);
        for (int i = 1; i <= s.length(); i++) {
            String partition1 = s.substring(0, i);
            String partition2 = s.substring(i);
            if ((dicitonary.contains(partition1) && isValid(partition2, map, dicitonary))) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
    public static void main(String[] args) {
        wordBreak wordBreak = new wordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
    }
}
