#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    
    int resultant [3] = {0, 0, 0};
    int force [3];
    
    for (int i = 0; i < n; i++) {
        cin >> force[0] >> force[1] >> force[2];
        
        resultant[0] += force[0];
        resultant[1] += force[1];
        resultant[2] += force[2];
    }
    
    if (resultant[0] == 0 && resultant[1] == 0 && resultant[2] == 0) {
        cout << "YES" << "\n";
    } else {
        cout << "NO" << "\n";
    }
    
    return 0;
}
