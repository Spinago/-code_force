import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AlphabetAnimals {
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
    }

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Reader reader = new Reader();

        int[] usedLetters = new int[26];
        String prevAnimal = reader.next();
        char lastChar = prevAnimal.charAt(prevAnimal.length() - 1);
        int listSize = Integer.parseInt(reader.next());

        ArrayList<String> myAnimals = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < listSize; i++) {
            String animal = reader.next();

            usedLetters[ALPHABET.indexOf(animal.charAt(0))]++;
            if (animal.charAt(0) == lastChar) {
                myAnimals.add(animal);
            }
        }

        if (myAnimals.size() == 0) {
            System.out.println("?");
        } else {
            for (String animal : myAnimals) {
                usedLetters[ALPHABET.indexOf(animal.charAt(0))]--;
                if (usedLetters[ALPHABET.indexOf(animal.charAt(animal.length() - 1))] == 0) {
                    System.out.println(animal + "!");
                    found = true;
                    break;
                }
                usedLetters[ALPHABET.indexOf(animal.charAt(0))]++;
            }

            if (!found) {
                System.out.println(myAnimals.get(0));
            }
        }
    }
}


