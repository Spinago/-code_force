#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, k, kThV = 0, count = 0;
    cin >> n >> k;
    
    for (int i = 0; i < n; i++) {
        int q;
        cin >> q;
        
        if (q <= 0) {
            break;
        } else if (i + 1 <= k) {
            count++;
            if (i + 1 == k) {
                kThV = q;
            }
        } else if (i + 1 > k) {
            if (q < kThV) {
                break;
            }
            count++;
        }
    }
    
    cout << count;
    
    return 0;
}

