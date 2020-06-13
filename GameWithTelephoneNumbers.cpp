#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    string s;
    cin >> n >> s;
    
    int v = (n - 11) / 2;
    int p = v;
    
    string endString = "";
    
    for (int i = 0; i < n; i++) {
        if (s[i] == '8') {
            if (p > 0) {
                p--;
            } else {
                endString += s[i];
            }
        } else {
            if (v > 0) {
                v--;
            } else {
                endString += s[i];
            }
        }
    }
    
    if (endString[0] == '8') {
        cout << "YES\n";
    } else {
        cout << "NO\n";
    }
    
    return 0;
}
