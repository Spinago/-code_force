import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HonourThyApaxianParent {
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
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        String firstName = reader.next();
        String secondName = reader.next();

        char lastChar = firstName.charAt(firstName.length() - 1);

        if (lastChar == 'e') {
            System.out.println(firstName + "x" + secondName);
        } else if (firstName.substring(firstName.length() - 2).equals("ex")) {
            System.out.println(firstName + secondName);
        } else if (lastChar == 'a' || lastChar == 'i' || lastChar == 'u' || lastChar == 'o') {
            System.out.println(firstName.substring(0, firstName.length() - 1) + "ex" + secondName);
        } else {
            System.out.println(firstName + "ex" + secondName);
        }
    }
}
