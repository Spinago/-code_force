#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;
    int* arr = new int[n + 1];
    

    for (int i = 0; i < n - 1; i++) {
        int m; cin >> m;
        arr[m] = 1;
    }  

    for (int i = 1; i < n + 1; i++) {
        if (arr[i] != 1) {
            cout << i;
            break;
        }     
    }

    return 0;
}