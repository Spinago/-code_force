#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    
    vector<string> nList;
    int matchingWords = 0;
    
    for (int i = 0; i < n + m; i++) {
        string word;
        cin >> word;
        
        if (i < n) {
            nList.push_back(word);
        } else {
            
            for (int j = 0; j < n; j++) {
                if (nList[j] == word) {
                    matchingWords++;
                    nList.erase(nList.begin() + j);
                }
            }
        }
    }
    
    if ((n == m && matchingWords % 2 == 0) || n < m) {
        cout << "NO\n";
    } else {
        cout << "YES\n";
    }
    
    return 0;
}

