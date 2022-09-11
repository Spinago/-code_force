import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpfulMaths {
    static class Reader {
        BufferedReader br;

        private Reader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String nextLine() {
            String str = "";

            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }

            return str;
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();

        String sum = reader.nextLine();
        StringBuilder sumBuilder = new StringBuilder(sum.length());
        sum.chars().sorted().forEach(i -> {
            if (i > 47 && i < 58) {
                sumBuilder.append((char) i).append('+');
            }
        });
        sumBuilder.deleteCharAt(sumBuilder.length() - 1);
        System.out.println(sumBuilder.toString());

    }
}
