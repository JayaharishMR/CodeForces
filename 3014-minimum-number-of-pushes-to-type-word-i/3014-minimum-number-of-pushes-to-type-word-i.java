class Solution {
    public int minimumPushes(String word) {
        int count = 8;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res = res + 1 + i/count;
        }
        return res;
    }
}