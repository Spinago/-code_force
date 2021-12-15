import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ColoringSocks {
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

        int sockNum = reader.nextInt();
        int capacity = reader.nextInt();
        int maxAbDif = reader.nextInt();

        int[] socks = new int[sockNum];
        for (int i = 0; i < sockNum; i++) { socks[i] = reader.nextInt(); }

        Arrays.sort(socks);

        int j = 0;
        int machinesCount = 0;
        while (j < sockNum) {
            for (int k = 1; k <= capacity; k++) {
                if (j + k >= sockNum || k == capacity || socks[j + k] - socks[j] > maxAbDif) {
                    machinesCount++;
                    j += k;
                    break;
                }
            }
        }

        System.out.println(machinesCount);
    }
}