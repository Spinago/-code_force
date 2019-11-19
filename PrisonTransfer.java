import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrisonTransfer {
    static class Reader {
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main (String[] args) {
        Reader reader = new Reader();
        int n = reader.nextInt(), t = reader.nextInt(), c = reader.nextInt();

        int wayNum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int prisoner = reader.nextInt();
            if (prisoner > t || i == n) {
                if (i == n && !(prisoner > t)) {
                    count++;
                }
                wayNum += Math.max(0, count - c + 1);
                count = 0;
            } else {
                count++;
            }
        }

        System.out.println(wayNum);
    }
}
