class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        int res = 0;
        int m = 4;
        for (int i = 1000; i <= n; i++) {
            int a = m/3;
            if (m%3 == 0) {
                a--;
            }
            res += a;
            m = getLength(i);
        }
        return res;
    }

    public int getLength(int a) {
        int res = 0;
        while(a > 0) {
            res++;
            a = a/10;
        }
        return res;
    }
}