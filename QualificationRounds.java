import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QualificationRounds {
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

        String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int problemNum = reader.nextInt();
        reader.nextInt();

        ArrayList<Integer> masks = new ArrayList<>();
        for (int i = 0; i < problemNum; i++) {
            int mask = Integer.parseInt(reader.nextLine().replaceAll(" ", ""), 2);

            if (!masks.contains(mask)) {
                masks.add(mask);
            }
        }

        boolean isPossible = false;
        for (int i = 0; i < masks.size(); i++) {
            if (isPossible) { break; }

            for (int j = i; j < masks.size(); j++) {
                if ((masks.get(i) & masks.get(j)) == 0) {
                    isPossible = true;
                    break;
                }
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
