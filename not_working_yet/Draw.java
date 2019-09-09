import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Draw {
    private static class FastReader {
        BufferedReader br;

        public FastReader() {
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

    private static int[][] getInputs() {
        FastReader reader = new FastReader();

        int numberOfInstances = Integer.parseInt(reader.nextLine());
        int[][] instances = new int[numberOfInstances][2];


        for (int i = 0; i < numberOfInstances; i++) {
            int[] score = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            instances[i][0] = score[0];
            instances[i][1] = score[1];
        }

        return instances;
    }

    public static void main(String args[]) {
        int[][] instances = getInputs();
        System.out.println(solve(instances));
    }

    private static int solve(int[][] instances) {
        int ties = 0;

        if (instances.length == 1 || !(instances[0][0] == 0 && instances[0][1] == 0)) {
            int[] zeros = {0, 0};
            int dif = getSmallestDifference(zeros, instances[0]);

            if (dif < 1) { dif = 1; }
            else { dif += 1; }

            ties += dif;
        }

        for (int i = 0; i < instances.length - 1; i++) {
            int[] firstInst = instances[i];
            int[] secInst = instances[i + 1];

            if (!(firstInst[0] == firstInst[1] && Arrays.equals(firstInst, secInst))
                    && !(firstInst[0] < firstInst[1] && secInst[0] < secInst[1])
                    && !(firstInst[0] > firstInst[1] && secInst[0] > secInst[1])) {

                if (secInst[0] == secInst[1]) {
                    ties += getBiggestDifference(firstInst, secInst);
                } else if (!(firstInst[0] == firstInst[1] && (secInst[0] == firstInst[0] || firstInst[1] == secInst[1]))) {
                    int dif = getSmallestDifference(firstInst, secInst);

                    if (dif < 1) dif = 1;

                    ties += dif;
                }
            }

            if (i == 0 && firstInst[0] == 0 && firstInst[1] == 0 && secInst[0] == secInst[1]) {
                ties += 1;
            }
        }

        return ties;
    }

    private static int getSmallestDifference(int[] f, int[] s) {
        if (s[0] - f[0] > s[1] - f[1]) {
            return s[1] - f[1];
        }
        return s[0] - f[0];
    }

    private static int getBiggestDifference(int[] f, int[] s) {
        if (s[0] - f[0] > s[1] - f[1]) {
            return s[0] - f[0];
        }
        return s[1] - f[1];
    }
}