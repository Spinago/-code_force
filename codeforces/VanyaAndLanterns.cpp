#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, l;
    cin >> n >> l;
    
    vector<double> v(n);
    
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    
    sort(v.begin(), v.end());
    
    double d = 0;
    if (v[0] != 0) {
        d = v[0];
    }
    
    for (int i = 0; i < v.size() - 1; i++) {
        if ((v[i+1] - v[i]) / 2 > d) {
            d = (v[i+1] - v[i]) / 2;
        }
    }
    
    if (l - v.back() > d) {
        d = l - v.back();
    }
    
    cout << fixed << d;
    return 0;
}
