#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, q[2], k[2], d[2];
    cin >> n >> q[0] >> q[1] >> k[0] >> k[1] >> d[0] >> d[1];
    
    if ((k[0] > q[0] && d[0] > q[0]) || (k[0] < q[0] && d[0] < q[0])) {
        if ((k[1] > q[1] && d[1] > q[1]) || (k[1] < q[1] && d[1] < q[1])) {
            cout << "YES";
        } else {
            cout << "NO";
        }
    } else {
        cout << "NO";
    }
    
    return 0;
}
