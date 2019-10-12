import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AnagramCounting {
    static class Reader {
        BufferedReader br;

        private Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        while (true) {
            HashMap<Character, Integer> charCount = new HashMap<>();
            String word = reader.nextLine();

            for (int i = 0; i < word.length(); i++) {
                if (!charCount.containsKey(word.charAt(i))) {
                    charCount.put(word.charAt(i), 1);
                } else {
                    charCount.put(word.charAt(i), charCount.get(word.charAt(i)) + 1);
                }
            }

            BigInteger divider = new BigInteger("1");
            for (Map.Entry character : charCount.entrySet()) {
                divider = divider.multiply(factorial(BigInteger.valueOf((int) character.getValue())));
            }

            System.out.println(factorial(BigInteger.valueOf(word.length())).divide(divider));

            try {
                if (!reader.br.ready()) { break; }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
