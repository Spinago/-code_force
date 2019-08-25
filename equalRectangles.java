import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class SpeedReader {
        BufferedReader br;

        private SpeedReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        private String nextLine() {
            String str = "";

            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }

            return str;
        }
    }

    private static ArrayList<int[]> getCases() {
        SpeedReader reader = new SpeedReader();
        ArrayList<int[]> cases = new ArrayList<>();

        // I need this variable in order to 'consume' the line
        int caseNumber = Integer.parseInt(reader.nextLine());
        for (int i = 0; i < caseNumber; i++) {
            reader.nextLine();
            int[] sticks = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cases.add(sticks);
        }

        return cases;
    }

    public static void main(String[] args) {
        ArrayList<int[]> cases = getCases();

        for (int[] theCase : cases) {
            System.out.println(solveCase(theCase));
        }
    }

    private static String solveCase(int[] stickLengths) {
        Arrays.sort(stickLengths);
        int area = stickLengths[0] * stickLengths[stickLengths.length - 1];
        int[] factors = getFactors(area);
        HashMap<Integer, Integer> stickLengthsCount = getStickLengthsCount(stickLengths);

        // checking if I have an even number of each number
        for (Map.Entry<Integer, Integer> stickLength : stickLengthsCount.entrySet()) {
            if (stickLength.getValue() % 2 == 1) {
                return "NO";
            }
        }

        for (int i = 0; i < factors.length / 2; i++) {
            // the 'brother factor' is a factor that, when multiplied with its brother, creates the original number
            int brotherFactor = factors[(factors.length - 1) - i];

            for (int stick : stickLengths) {
                if (stick == factors[i]) {
                    if (isIntPresentInArr(brotherFactor, stickLengths)) {
                        if (stickLengthsCount.get(factors[i]) != stickLengthsCount.get(brotherFactor)) {
                            return "NO";
                        }
                    } else {
                        return "NO";
                    }
                } else if (stick == brotherFactor && !isIntPresentInArr(factors[i], stickLengths)) {
                    return "NO";
                } else if (!isIntPresentInArr(stick, factors)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    private static int[] getFactors(int area) {
        ArrayList<Integer> factorsList = new ArrayList<>();

        for (int i = 1; i <= area; ++i) {
            if (area % i == 0) {
                factorsList.add(i);
            }
        }

        return factorsList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static HashMap<Integer, Integer> getStickLengthsCount(int[] sticks) {
        HashMap<Integer, Integer> stickCount = new HashMap<>();

        for (int stick : sticks) {
            if (!stickCount.containsKey(stick)) {
                stickCount.put(stick, 1);
            } else {
                stickCount.put(stick, stickCount.get(stick) + 1);
            }
        }

        return stickCount;
    }

    private static boolean isIntPresentInArr(int elem, int[] arr) {
        for (int element : arr) {
            if (element == elem) {
                return true;
            }
        }
        return false;
    }
}
