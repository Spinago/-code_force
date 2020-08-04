#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, k;
    cin >> n >> k;
    
    int count = 0, timeLeftToSolveProblems = 240 - k;
    
    for (int i = 1; i <= n; i++) {
        int timeToSolve = i * 5;
        
        timeLeftToSolveProblems -= timeToSolve;
        
        if (timeLeftToSolveProblems < 0) {
            break;
        }
        
        count ++;
    }
    
    cout << count << endl;
    
    return 0;
}

