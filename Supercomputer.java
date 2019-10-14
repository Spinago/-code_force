import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Supercomputer {
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

        ArrayList<Integer> ones = new ArrayList<>();

        reader.next();
        int queriesNum = reader.nextInt();
        for (int i = 0; i < queriesNum; i++) {
            String op = reader.next();

            if (op.equals("F")) {
                int pos = reader.nextInt();
                int index = Collections.binarySearch(ones, pos);

                if (index >= 0) {
                    ones.remove(index);
                } else {
                    ones.add(~index, pos);
                }
            } else {
                int min = Collections.binarySearch(ones, reader.nextInt());
                int max = Collections.binarySearch(ones, reader.nextInt());
                if (min < 0) { min = ~min; }

                if (max < 0) { max = ~max; }
                else { max++; }

                System.out.println(max - min);
            }
        }
    }
}
