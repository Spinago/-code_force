import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConstanzesMachine {
    private static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        String str = reader.next();
        long MOD = (long) Math.pow(10, 9) + 7;
        long[] dp = new long[str.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= str.length(); i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if (dp[i] >= MOD) {
                dp[i] %= MOD;
            }
        }

        long sn = 1;

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == 'm' || curr == 'w') {
                sn = 0;
                break;
            }

            int j = 1;

            if (curr == 'u') {
                while (i + j < str.length() && str.charAt(i + j) == 'u') {
                    j++;
                }

                sn *= dp[j];
                i += j - 1;
            } else if (curr == 'n') {
                while (i + j < str.length() && str.charAt(i + j) == 'n') {
                    j++;
                }

                sn *= dp[j];
                i += j - 1;
            }
            sn %= MOD;
        }

        System.out.println(sn % MOD);
    }
}
