class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        int res = 0;
        int m = 4;
        int checkPoint = 10000;
        for (int i = 1000; i <= n; i++) {
            int a = m/3;
            if (m%3 == 0) {
                a--;
            }
            res += a;
            if (i == checkPoint) {
                m++;
                checkPoint *= 10;
            }
        }
        return res;
    }

}