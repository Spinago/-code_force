#include <bits/stdc++.h>

using namespace std;

#define ARR_MAX 100001

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n; cin >> n;
    int arr[ARR_MAX] = {0};
    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        arr[x]++;
    }

    for (int i = 2; i < ARR_MAX; i++) {
        arr[i] += arr[i - 1];
    }

    int q; cin >> q;
    for (int i = 0; i < q; i++) {
        int m; cin >> m;

        if (m > 100000) 
            cout << arr[100000] << "\n";
        else 
            cout << arr[m] << "\n";
    }

    return 0;
}