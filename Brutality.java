import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Brutality {
    static class SpeedReader {
        BufferedReader br;

        private SpeedReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String nextLine() {
            String str = "";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }

    private static String sequence;
    private static int keyboardHP;
    private static long[] hitsDamage;

    private static void getInputs() {
        SpeedReader reader = new SpeedReader();

        keyboardHP = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];
        hitsDamage = Arrays.stream(reader.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        sequence = reader.nextLine() + "@";
    }

    public static void main(String[] args) {
        getInputs();
        System.out.println(solve());
    }

    private static long solve() {
        char prev = '@';
        long dmg = 0;
        ArrayList<Long> dmgInARow = new ArrayList<>();

        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if (current != prev) {
                dmg += dmgInARow.stream().mapToLong(Long::longValue).sum();

                if (dmgInARow.size() > keyboardHP) {
                    Collections.sort(dmgInARow);
                    for (int j = 0; j < dmgInARow.size() - keyboardHP; j++) {
                        dmg -= dmgInARow.get(j);
                    }
                }

                if (current == '@') {
                    break;
                }

                dmgInARow = new ArrayList<>();
                dmgInARow.add(hitsDamage[i]);
                prev = current;
            } else {
                dmgInARow.add(hitsDamage[i]);
            }
        }

        return dmg;
    }
}