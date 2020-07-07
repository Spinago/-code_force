#include <bits/stdc++.h>
 
using namespace std;
 
int binarySearch(vector<unsigned long long> &arr, int leftBound, int rightBound, unsigned long long x) {
    
    if (rightBound >= leftBound) {
        int mid = leftBound + (rightBound - leftBound) / 2;
  
        if (arr[mid] == x) {
            return mid;
        }
        
        if (arr[mid] > x) {
            return binarySearch(arr, leftBound, mid - 1, x);
        }
            
        return binarySearch(arr, mid + 1, rightBound, x);
        
    }
    
    return leftBound;
}
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    unsigned long long firstDorm;
    cin >> n >> m >> firstDorm;
    
    vector<unsigned long long> dormRoomSum;
    
    dormRoomSum.push_back(firstDorm);
    
    for (int i = 1; i < n; i++) {
        unsigned long long q;
        cin >> q;
        dormRoomSum.push_back(q + dormRoomSum[i - 1]);
    }
    
    for (int i = 0; i < m; i++) {
        unsigned long long roomNum;
        cin >> roomNum;
        
        int dorm = binarySearch(dormRoomSum, 0, n - 1, roomNum);
 
        cout << dorm + 1 << " ";
        
        if (dorm == 0) {
             cout << roomNum;
        } else {
            cout << roomNum - dormRoomSum[dorm - 1];
        }
        
        cout << endl;
    }
    
    return 0;
}
