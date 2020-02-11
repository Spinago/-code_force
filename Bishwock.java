import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bishwock {
    static class Reader {
        BufferedReader br;

        Reader() {
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
        String[][] board = new String[2][];
        board[0] = reader.nextLine().split("");
        board[1] = reader.nextLine().split("");

        int total = 0;
        int previousVacancy = 0;
        for (int i = 0; i < board[0].length; i++) {
            int currentColumnVacancy = 0;
            if (board[0][i].equals("0")) { currentColumnVacancy++; }
            if (board[1][i].equals("0")) { currentColumnVacancy++; }

            previousVacancy += currentColumnVacancy;

            if (previousVacancy >= 3) {
                previousVacancy -=3;
                total++;
            } else {
                previousVacancy = currentColumnVacancy;
            }
        }

        System.out.println(total);
    }
}

