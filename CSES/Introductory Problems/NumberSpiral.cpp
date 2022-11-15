#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t; cin >> t;

    for (int i = 0; i < t; i++) {
        ll y, x; cin >> y >> x;

        if (y == 1 && x == 1) {
            cout << 1 << "\n";
            continue;
        }

        ll n;
        if (y > x && y % 2 == 0) {
            n = (y * y) - x + 1;

        } else if (y > x) {
            n = ((y - 1) * (y - 1)) + x;

        } else if (x % 2 == 1) {
            n = (x * x) - y + 1;

        } else {
            n = ((x - 1) * (x - 1)) + y;
        }

        cout << n << "\n";
    }

    return 0;
}
