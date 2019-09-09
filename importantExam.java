import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ImportantExam {
    static class FastReader {
        BufferedReader br;

        private FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String nextLine() {
            String str = "";

            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }

            return str;
        }
    }

    private static ArrayList<char[]> getTests(FastReader reader) {
        ArrayList<char[]> tests = new ArrayList<>();

        int studentNum = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()[0];
        for (int i = 0; i < studentNum; i++) {
            tests.add(reader.nextLine().toCharArray());
        }

        return tests;
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        ArrayList<char[]> tests = getTests(reader);
        HashMap<Integer, int[]> answerCount = countAnswers(tests);
        int[] answerPointValues = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getMaxClassScore(answerCount, answerPointValues));

    }

    private static HashMap<Integer, int[]> countAnswers(ArrayList<char[]> tests) {
        int NUMBER_OF_QUESTIONS = tests.get(0).length;

        HashMap<Integer, int[]> countPerAnswer = new HashMap<>();

        for (int i = 1; i <= NUMBER_OF_QUESTIONS; i++) {
            int[] arr = new int[5];
            countPerAnswer.put(i, arr);
        }

        for (char[] test : tests) {
            for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
                int[] arr = countPerAnswer.get(i + 1);

                switch (test[i]) {
                    case 'A':
                        arr[0] += 1;
                        break;
                    case 'B':
                        arr[1] += 1;
                        break;
                    case 'C':
                        arr[2] += 1;
                        break;
                    case 'D':
                        arr[3] += 1;
                        break;
                    case 'E':
                        arr[4] += 1;
                        break;
                }

                countPerAnswer.put(i + 1, arr);
            }
        }
        return countPerAnswer;
    }

    private static int getMaxClassScore(HashMap<Integer, int[]> answerCount, int[] answerPointValues) {
        int totalScore = 0;

        for (int i = 0; i < answerPointValues.length; i++) {
            int biggestCount = 0;

            for (int count : answerCount.get(i + 1)) {
                if (count > biggestCount) biggestCount = count;
            }

            totalScore += biggestCount * answerPointValues[i];
        }

        return totalScore;
    }
}
