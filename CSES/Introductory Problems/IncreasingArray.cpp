#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    long long moves = 0;

    int prev; cin >> prev;

    for (int i = 1; i < n; i++) {
        int curr; cin >> curr;

        if (curr < prev) {
            moves += prev - curr;
            curr = prev;
        }

        prev = curr;
    }
    
    cout << moves;

    return 0;
}