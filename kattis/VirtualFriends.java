import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class VirtualFriends {
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

    static class DisjointSet {
        int[] rank, parent, size;
        int n;

        private DisjointSet(int n) {
            rank = new int[n];
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int j) {
            if (parent[j] != j) {
                parent[j] = find(parent[j]);
            }

            return parent[j];
        }

        int getSizeOfSet(int g) {
            return size[find(g)];
        }

        void union(int k, int h) {
            int kRoot = find(k), hRoot = find(h);

            if (kRoot == hRoot) {
                return;
            }

            size[kRoot] += size[hRoot];
            size[hRoot] += (size[kRoot] - size[hRoot]);

            if (rank[kRoot] < rank[hRoot]) {
                parent[kRoot] = hRoot;
            } else if (rank[hRoot] < rank[kRoot]) {
                parent[hRoot] = kRoot;
            } else {
                parent[hRoot] = kRoot;
                rank[kRoot] = rank[kRoot] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Reader reader = new Reader();
        int testCaseNum = Integer.parseInt(reader.next());

        for (int i = 0; i < testCaseNum; i++) {
            int friendsShips = Integer.parseInt(reader.next());

            String[][] unions = new String[friendsShips][2];
            HashMap<String, Integer> names = new HashMap<>();
            int index = 0;

            for (int j = 0; j < friendsShips; j++) {
                String fName = reader.next(), sName = reader.next();
                unions[j] = new String[] {fName, sName};

                if (!names.containsKey(fName)) {
                    names.put(fName, index);
                    index++;
                }
                if (!names.containsKey(sName)) {
                    names.put(sName, index);
                    index++;
                }
            }

            DisjointSet disjointSet = new DisjointSet(names.size());
            for (String[] union : unions) {
                int f = names.get(union[0]), s = names.get(union[1]);
                disjointSet.union(f, s);
                System.out.println(disjointSet.getSizeOfSet(f));
            }
        }
    }
}

