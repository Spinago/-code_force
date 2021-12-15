#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    string k, d;
    cin >> k >> d;
    
    string alph = "abcdefgh";
    
    size_t d1 = alph.find(d.at(0));
    int d2 = (int) d.at(1);
    
    size_t k1 = alph.find(k.at(0));
    int k2 = (int) k.at(1);
    
    vector<string> moves;
    int moveNum = 0;
    
    while (k1 != d1 || k2 != d2) {
        string move = "";
        
        if (k1 != d1) {
            if (k1 > d1) {
                move.append("L");
                k1--;
            } else {
                move.append("R");
                k1++;
            }
        }
        
        if (k2 != d2) {
            if (k2 > d2) {
                move.append("D");
                k2--;
            } else {
                move.append("U");
                k2++;
            }
        }
        
        moves.push_back(move);
        moveNum++;
    }
    
    cout << moveNum << endl;
    for (string move : moves) {
        cout << move << endl;
    }
    
    return 0;
}

