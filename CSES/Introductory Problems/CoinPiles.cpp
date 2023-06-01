#include <bits/stdc++.h>

#define ll long long

using namespace std;


int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    ll t, a, b;
    cin >> t;
    while(t--) {
        cin >> a >> b;
        if ((a + b) % 3 == 0 && min(a, b) * 2 >= max(a, b)) {
            cout << "YES\n";
            continue;
        }
        cout << "NO\n";
    }
    

    return 0;
}