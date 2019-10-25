import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KefaAndFirstSteps {
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

        int numberOfDays = reader.nextInt();

        int biggestSubsegment = 0;
        int subsegmentLength = 0;
        int prev = 0;
        for (int i = 0; i < numberOfDays; i++) {
            int n = reader.nextInt();

            if (n >= prev) {
                subsegmentLength++;
            }

            if (i + 1 == numberOfDays || n < prev) {
                biggestSubsegment = Math.max(subsegmentLength, biggestSubsegment);
                subsegmentLength = 1;
            }

            prev = n;
        }

        System.out.println(biggestSubsegment);
    }
}

