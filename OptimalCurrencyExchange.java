import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static class Reader {
        BufferedReader br;

        public Reader() {
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

    private static int[] getInputs() {
        Reader reader = new Reader();
        return new int[] {Integer.parseInt(reader.nextLine()), Integer.parseInt(reader.nextLine()), Integer.parseInt(reader.nextLine())};
    }

    public static void main(String[] args) {
        int[] inputs = getInputs();
        System.out.println(solve(inputs));
    }

    private static int solve(int[] inputs) {
        int rubles = inputs[0];
        int dollarConversion = inputs[1];
        int euroConversion = inputs[2];
        int dollarRemainder = rubles % dollarConversion;
        int euroRemainder = rubles % euroConversion;

        int smallestRemainder;

        if (euroRemainder < dollarRemainder && Math.floor(rubles / euroConversion) % 5 == 0) {
            int currentRubles = rubles;
            smallestRemainder = euroRemainder;
            while (currentRubles - euroConversion > 0) {
                currentRubles -= euroConversion;
                if (currentRubles % dollarConversion < smallestRemainder) {
                    smallestRemainder = currentRubles % dollarConversion;
                }
            }
        } else {
            int currentRubles = rubles;
            smallestRemainder = dollarRemainder;
            while (currentRubles - dollarConversion > 0) {
                currentRubles -= dollarConversion;
                if (currentRubles % euroConversion < smallestRemainder && Math.floor(currentRubles / euroConversion) % 5 == 0) {
                    smallestRemainder = currentRubles % euroConversion;
                }
            }
        }

        return smallestRemainder;
    }
}