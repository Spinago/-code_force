#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    string s; cin >> s;
    
    string h = "hello";
    int j = 0;
    
    for (int i = 0; i < s.size(); i++) {
        if (h[j] == s[i]) j++;
    }
    
    if (j == h.size()) {
        cout << "YES";
    } else {
        cout << "NO";
    }
    
    return 0;
}
