#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, c;
    cin >> n;
    
    vector<int> v(n);
    int index = 0;
    
    for (int i = 0; i < n; i++) {
        cin >> c;
        v[i] = c % 2;
        
        if (i >= 2) {
            if (v[i] != v[i-1] && v[i] != v[i-2]) {
                index = i;
                break;
            } else if (v[i-1] != v[i] && v[i-1] != v[i-2]) {
                index = i-1;
                break;
            } else if (v[i-2] != v[i] && v[i-2] != v[i-1]) {
                index = i-2;
                break;
            }
        }
    }
    
    cout << index+1 << "\n";
    
    return 0;
}
