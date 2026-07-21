class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        boolean[] vis = new boolean[26];
        for (char c : s.toCharArray()) {
            arr[c-'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (vis[curr-'a'] == true) {
                arr[curr -'a']--;
                continue;
            }
            while (sb.length() >= 1 && sb.charAt(sb.length()-1) > curr && arr[sb.charAt(sb.length()-1) - 'a'] != 0) {
                vis[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(curr);
            vis[curr-'a'] = true;
            arr[curr -'a']--;
        }
        return sb.toString();
    }
}