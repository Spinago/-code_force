import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FridayThe13th {
    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while(st == null || !st.hasMoreElements()) {
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

        int testCaseNum = reader.nextInt();
        for (int i = 0; i < testCaseNum; i++) {
            reader.nextInt();
            int count = 0;
            int monthsInYear = reader.nextInt();
            int nextStartingDay = 0;

            for (int j = 0; j < monthsInYear; j++) {
                int daysInMonth = reader.nextInt();
                if (nextStartingDay == 0 && daysInMonth >= 13) {
                    count++;
                }

                nextStartingDay += (daysInMonth % 7);
                if (nextStartingDay >= 7) {
                    nextStartingDay = nextStartingDay % 7;
                }
            }

            System.out.println(count);
        }
    }
}
