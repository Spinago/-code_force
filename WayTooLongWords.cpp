#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    const int MAX_LENGTH = 10;
    
    int i;
    cin >> i;
    
    while (i > 0) {
        string str;
        cin >> str;
        
        if (str.length() <= MAX_LENGTH) {
            cout << str << "\n";
        } else {
            cout << str.at(0) << str.length() - 2 << str.at(str.length() - 1) << "\n";
        }
        
        i--;
    }
    
    return 0;
}
