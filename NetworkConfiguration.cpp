#include <iostream>
#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, k;
    cin >> n >> k;
    
    vector<int> c;
    
    int var;
    for (int i = 0; i < n; i++) {
        cin >> var;
        c.push_back(var);
    }
    
    sort(c.begin(), c.end(), greater<int>());
    
    cout << c.at(k - 1) << "\n";

    return 0;
}

