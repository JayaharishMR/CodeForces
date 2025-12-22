import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gidx = g.length -1;
        int sidx = s.length -1;
        int output = 0;
        while (gidx >=0 && sidx >=0) {
            if (g[gidx] <= s[sidx]) {
                output++;
                gidx--;
                sidx--;
            } else {
                gidx--;
            }
        }
        return output;
    }
}
