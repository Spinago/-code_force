#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string s; cin >> s;

    int max = 1, count = 1;
    char prev = s.at(0);

    for (int i = 1; i < s.length(); i++) {
        char curr = s.at(i);
        if (curr == prev) count++;
        else {
            max = (max < count) ? count : max;
            count = 1;
        }
        prev = curr;
    }
    max = (max < count) ? count : max;

    cout << max;

    return 0;
}