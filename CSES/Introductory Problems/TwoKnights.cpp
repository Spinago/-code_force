#include <bits/stdc++.h>

typedef long long ll;

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n; cin >> n;
    cout << 0 << "\n";
    for (ll k = 2; k <= n; k++) {
        ll nPos = (k * k) * ((k * k) - 1) / 2;
        ll nAttacks = (k - 1) * (k - 2) * 8 / 2;

        cout << nPos - nAttacks << "\n";
    }

    return 0;
}