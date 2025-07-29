import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Tournament_2123B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(reader.readLine());
        while (v-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int j = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int[] players = new int[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                players[i] = Integer.parseInt(tokenizer.nextToken());
            }
            if ( k > 1) {
                System.out.println("YES");
            } else {
                j--;
                int strengthOfJ = players[j];
                int max = Arrays.stream(players).max().getAsInt();
                if (strengthOfJ == max) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

