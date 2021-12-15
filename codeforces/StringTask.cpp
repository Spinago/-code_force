#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    string s;
    cin >> s;
    
    for_each(s.begin(), s.end(), [](char& c) {
        c = tolower(c);
    });
    
    s = regex_replace(s, regex("[aoyeui]"), "");
    
    for (int i = 0; i < s.length(); i += 2) {
        s.insert(i, ".");
    }
    
    cout << s;
    return 0;
}
