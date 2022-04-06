#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, k; cin >> n >> k;
    
    int arr[n];
    int min;
    int sum = 0;
    int left = 0;
    int index = 1;
    
    for (int i = 0; i < k; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    
    min = sum;
    
    for (int i = k; i < n; i++) {
        cin >> arr[i];
        
        sum -= arr[left];
        left++;
        
        sum += arr[i];
    
        
        if (min > sum) {
            min = sum;
            index = i + 2 - k;
        }
    }
    
    
    cout << index << "\n";

    return 0;
}
