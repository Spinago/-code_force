import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumbersOnATree {
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

        int height = reader.nextInt();
        long root = (long) Math.pow(2, height + 1) - 1;

        if (!reader.st.hasMoreElements()) {
            System.out.println(root);
        } else {
            char[] path = reader.next().toCharArray();
            int index = 1;
            long node = 0;

            for (char direction : path) {
                if (direction == 'L') {
                    index *= 2;
                    node = root - (index - 1);
                } else {
                    index = index * 2 + 1;
                    node = root - (index - 1);
                }
            }

            System.out.println(node);
        }
    }
}
