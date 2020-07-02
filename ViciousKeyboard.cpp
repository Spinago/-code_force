#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    string str;
    cin >> str;
    
    int count = 0;
    bool stringChanged = false;
    
    for (int i = 0; i < str.length() - 1; i++) {
        string subStr = str.substr(i, 2);
        
        if (subStr == "VK") {
            count++;
        } else if (!stringChanged) {
            if (subStr == "VV" && (i + 2 == str.length() || str.at(i + 2) != 'K')) {
                count++;
                stringChanged = true;
            } else if (subStr == "KK" && (i == 0 || str.at(i - 1) != 'V')) {
                count++;
                stringChanged = true;
            }
        }
    }
    
    cout << count << endl;
    
    return 0;
}
