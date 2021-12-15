import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ants {
    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        private Reader() {
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

    public static void main(String[] args) {
        Reader reader = new Reader();

        int testCases = reader.nextInt();

        for (int i = 0; i < testCases; i++) {
            int length = reader.nextInt();
            int antNum = reader.nextInt();

            int min = 0;
            int max = 0;

            for (int j = 0; j < antNum; j++) {
                int ant = reader.nextInt();
                min = Math.max(Math.min(length - ant, ant), min);
                max = Math.max(Math.max(length - ant, ant), max);
            }

            System.out.println(min + " " + max);
        }
    }
}

