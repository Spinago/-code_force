#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n; cin >> n;

    for (int i = 4; i <= n; i++) {
        if (n % i == 0 && to_string(i).find_first_not_of("47") == string::npos) {
            cout << "YES";
            return 0;
        }
    }

    cout << "NO";

    return 0;
}