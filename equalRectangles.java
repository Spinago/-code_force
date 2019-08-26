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
        int numberOfSticks = stickLengths.length;
        int Area = stickLengths[0] * stickLengths[numberOfSticks - 1];
        HashMap<Integer, Integer> stickLengthsCount = getStickLengthsCount(stickLengths);

        // checking if I have an even number of each number
        for (Map.Entry<Integer, Integer> stickLength : stickLengthsCount.entrySet()) {
            if (stickLength.getValue() % 2 == 1) {
                return "NO";
            }
        }

        for (int i = 0; i < numberOfSticks / 2; i += 2) {
            int area = stickLengths[i] * stickLengths[(numberOfSticks - (i + 1))];
            if (area != Area) {
                return "NO";
            }
        }

        return "YES";
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
}