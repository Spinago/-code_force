import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IsItHalloween {
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
        String month = reader.next();
        int date = Integer.parseInt(reader.next());

        if ((month.equals("OCT") && date == 31) || (month.equals("DEC") && date == 25)) {
            System.out.println("yup");
        } else {
            System.out.println("nope");
        }
    }
}
