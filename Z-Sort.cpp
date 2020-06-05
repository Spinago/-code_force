#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    
    vector<int> z;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        z.push_back(a);
    }
    
    sort(z.begin(), z.end());
    
    for (int i = 1; i < n - 1; i += 2) {
        swap(z[i], z[i + 1]);
    }
    
    for (auto x: z) {
        cout << x << ' ';
    }
}

