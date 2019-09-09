// note, this works, but it is too slow for case seven which is a sequence of 20000 inputs.
    // i'll come back to this once I figure out a faster way

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

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

    private static char[] sequence;
    private static int keyboardHP;
    private static int[] hitsDamage;

    private static void getInputs() {
        SpeedReader reader = new SpeedReader();

        keyboardHP = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()[1];
        hitsDamage = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sequence = reader.nextLine().toCharArray();
    }

    public static void main(String[] args) {
        getInputs();
        System.out.println(solve());
    }

    private static long solve() {
        long dmg = IntStream.of(hitsDamage).sum();
        ArrayList<int[]> charRanges = getCharRanges();

        for (int[] range : charRanges) {
            if (range[1] - range[0] > keyboardHP) {
                int hitsTooMany = range[1] - range[0] - keyboardHP;
                int[] damageRange = Arrays.copyOfRange(hitsDamage, range[0], range[1]);

                Arrays.sort(damageRange);
                for (int i = 0; i < hitsTooMany; i++) {
                    dmg -= damageRange[i];
                }
            }
        }

        return dmg;
    }

    private static ArrayList<int[]> getCharRanges() {
        ArrayList<int[]> ranges = new ArrayList<>();
        char prev = sequence[0];
        int startingIndex = 0;

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] != prev || i + 1 == sequence.length) {
                int n = i;
                if (i + 1 == sequence.length) n += 1;
                int[] range = { startingIndex, n };
                ranges.add(range);

                startingIndex = i;
            }
            prev = sequence[i];
        }
        return ranges;
    }
}
