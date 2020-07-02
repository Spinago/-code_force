#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        
        if (a + b + c >= 2) {
            count++;
        }
    }
    
    cout << count;
    
    return 0;
}

