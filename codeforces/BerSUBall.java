import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BerSUBall {
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

    public static void main(String[] args) {
        Reader reader = new Reader();

        int boysNum = reader.nextInt();
        int[] boys = new int[boysNum];
        for (int i = 0; i < boysNum; i++) {
            boys[i] = reader.nextInt();
        }

        int girlsNum = reader.nextInt();
        int[] girls = new int[girlsNum];
        for (int i = 0; i < girlsNum; i++) {
            girls[i] = reader.nextInt();
        }

        System.out.println(maxCouples(girls, boys));

    }

    static boolean canBeMatched(int boy, int[] girls, int[] boys, boolean[] seen, int[] matches) {
        for (int i = 0; i < girls.length; i++) {
            if ((boys[boy] - 1 == girls[i] || boys[boy] + 1 == girls[i] || boys[boy] == girls[i]) && !seen[i]) {
                seen[i] = true;
                if (matches[i] < 0 || canBeMatched(matches[i], girls, boys, seen, matches)) {
                    matches[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }

    static int maxCouples(int[] girls, int[] boys) {
        int[] matches = new int[girls.length];
        Arrays.fill(matches, -1);
        int count = 0;

        for (int i = 0; i < boys.length; i++) {
            boolean[] seen = new boolean[girls.length];
            if (canBeMatched(i, girls, boys, seen, matches)) {
                count++;
            }
        }

        return count;
    }
}
