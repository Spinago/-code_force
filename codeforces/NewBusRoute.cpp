#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
    
    vector<int> coordinates;
    
    for (int i = 0; i < n; i++) {
        int c;
        cin >> c;
        coordinates.push_back(c);
    }
    
    sort(coordinates.begin(), coordinates.end());
    
    int min = INT_MAX;
    int count = 1;
    
    for (int i = 0; i < n - 1; i++) {
        int dif = abs(coordinates[i] - coordinates[i + 1]);
        
        if (dif == min) {
            count++;
        } else if (min > dif) {
            count = 1;
            min = dif;
        }
    }
    
    cout << min << " " << count;
    
    return 0;
}
