import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class PrefixMinSuffixMax {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(reader.readLine());
        while (v-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int[] players = new int[n];
            tokenizer = new StringTokenizer(reader.readLine());
            int[] pre = new int[n];
            int[] suf = new int[n];
            for (int i = 0; i < n; i++) {
                players[i] = Integer.parseInt(tokenizer.nextToken());
                pre[i] = Math.min( i == 0 ? Integer.MAX_VALUE : pre[i-1], players[i]);
            }
            for (int i = n-1; i >= 0; i--) {
                suf[i] = Math.max( i == n-1 ? Integer.MIN_VALUE : suf[i+1], players[i]);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(players[i] == pre[i] || players[i] == suf[i] ? "1" : "0");
            }
            System.out.println();
        }
    }
}
