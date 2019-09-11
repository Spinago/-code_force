import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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

    private static long solve(int[][] instances) {
        long ties = 0;

        int[] prev = new int[] {0, 0};

        for (int i = 0; i < instances.length; i++) {
            int[] current = instances[i];

            if (Arrays.equals(prev, current) && !(i == 0)) {
                continue;
            }

            ties += Math.max(0, Math.min(current[0], current[1]) - Math.max(prev[0], prev[1]) + 1);

            if (prev[0] == prev[1] && !(i == 0)) {
                ties--;
            }

            prev = current;
        }

        return ties;
    }
}
