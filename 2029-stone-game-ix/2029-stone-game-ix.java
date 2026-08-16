class Solution {
    public boolean stoneGameIX(int[] stones) {
        int sum = 0;
        int rem1 = 0;
        int rem2 = 0;
        int rem0 = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i : stones) {
            if (i % 3 == 1) {
                rem1++;
            } else if (i % 3 == 2) {
                rem2++;
            } else {
                rem0++;
            }
        }

        if (rem0 % 2 == 0) {
            return rem1 >= 1 && rem2 >= 1;
        }

        return rem1 - rem2 > 2 || rem2 - rem1 > 2;
    }
}