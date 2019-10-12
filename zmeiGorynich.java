import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        private Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        private int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int caseNum = reader.nextInt();

        for (int i = 0; i < caseNum; i++) {
            int blowNum = reader.nextInt();
            double headNum = reader.nextInt();
            double biggestDifference = 0;

            int d = 0;
            for (int j = 0; j < blowNum; j++) {
                int r = reader.nextInt(), h = reader.nextInt();
                if (r - h > biggestDifference) { biggestDifference = r - h; }
                if (r > d) { d = r; }
            }

            if (d >= headNum) {
                System.out.println(1);
            } else {
                if (biggestDifference > 0) {
                    System.out.println((int) Math.ceil((headNum - d) / biggestDifference) + 1);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}