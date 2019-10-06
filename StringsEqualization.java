import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringsEqualization {
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
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCaseNum = Integer.parseInt(reader.next());
        String[] ans = new String[testCaseNum];

        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < testCaseNum; i++) {
            String[] strings = {reader.next(), reader.next()};

            for (int j = 0; j < letters.length(); j++) {
                if (strings[0].indexOf(letters.charAt(j)) > -1 && strings[1].indexOf(letters.charAt(j)) > -1) {
                    ans[i] = "yes";
                    break;
                }
            }

            if (ans[i] == null) {
                ans[i] = "no";
            }
        }

        Arrays.stream(ans).forEach(System.out::println);
    }

}
