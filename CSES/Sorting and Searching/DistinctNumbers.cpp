#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n; cin >> n;

    vector<int> vec(n);

    for (int i = 0; i < n; i++) {
        int x; cin >> x;
        vec[i] = x;
    }

    int count = 1;
    sort(vec.begin(), vec.end());
    for (int i = 1; i < n; i++) {
        if (vec[i] != vec[i - 1]) {
            count++;
        }
    }

    cout << count;
    
    return 0;
}