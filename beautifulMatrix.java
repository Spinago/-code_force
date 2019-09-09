import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeautifulMatrix {

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

    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        int moveNum = getNumberOfMoves(matrix);
        System.out.println(moveNum);
    }

    private static int[][] getMatrix() {
        FastReader reader = new FastReader();

        final int NUMBER_OF_LINES = 5;
        int[][] matrix = new int[NUMBER_OF_LINES][5];

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            String line = reader.nextLine();
            matrix[i] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }

    private static int getNumberOfMoves(int[][] matrix) {
        final int[] CENTER_POSITION = {3, 3};
        int[] positionOf1 = new int[2];

        // iterate through the matrix to find the one's position
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    positionOf1[0] = i + 1;
                    positionOf1[1] = j + 1;
                }
            }
        }
        // return the number of vertical moves required plus the number of horizontal moves required
        return Math.abs(CENTER_POSITION[0] - positionOf1[0]) + Math.abs(CENTER_POSITION[1] - positionOf1[1]);
    }
}
