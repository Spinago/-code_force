import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EenyMeeny {
    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        private Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int length = reader.nextLine().split(" ").length - 1;
        int kidsNum = reader.nextInt();

        ArrayList<ArrayList<String>> teams = new ArrayList<>();
        ArrayList<String> team1 = new ArrayList<>();
        ArrayList<String> team2 = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);

        ArrayList<String> kids = new ArrayList<>();

        for (int i = 0; i < kidsNum; i++) {
            kids.add(reader.next());
        }

        int index = 0;
        int teamNum = 0;
        for (int i  = 0; i < kidsNum; i++) {
            index += length;
            while (index >= kids.size()) {
                index -= kids.size();
            }

            teams.get(teamNum).add(kids.get(index));
            kids.remove(index);

            if (teamNum == 0) {
                teamNum++;
            } else {
                teamNum--;
            }
        }

        System.out.println(teams.get(0).size());
        for (String name : teams.get(0)) {
            System.out.println(name);
        }
        System.out.println(teams.get(1).size());
        for (String name : teams.get(1)) {
            System.out.println(name);
        }
    }
}