#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    string s; cin >> s;
    int alphabet[26] = {};

    for (int i = 0; i < s.length(); i++) {
        char c = s[i];
        alphabet[c - 65]++; // ASCII encoding
    }

    string s1 = "", s2 = "";
    int oddCount = 0;
    char oddChar;
    for (int i = 0; i < 26; i++) {
        char c = i + 65;
        if (alphabet[i] % 2 != 0) {
            oddCount++;
            oddChar = c;
            if (oddCount > 1 || (oddCount == 1 && s.length() % 2 == 0)) {
                cout << "NO SOLUTION";
                return 0;
            }
        }

        string s(alphabet[i] / 2, c);

        s1 = s1 + s;
        s2 = s + s2;
    }

    cout << (oddCount == 1 ? s1 + oddChar + s2 : s1 + s2);

    return 0;
}