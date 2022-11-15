#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;


    if (n == 3 || n == 2) {
        cout << "NO SOLUTION";
        return 0;
    }

    int i = 0;
    for (int k = 2; k <= n; i++, k += 2) {
        cout << k << " ";
    }

    for (int k = 1; k <= n; i++, k += 2) {
        cout << k << " ";
    }

    return 0;
}