#include <iostream>

using namespace std;

int main(int argc, const char * argv[]) {
    int weight;
    cin >> weight;
    
    if (weight % 2 != 0) {
        cout << "NO\n";
    } else {
        int otherHalf = weight / 2;
        
        for (int i = weight / 2; i < weight; i++) {
            if (otherHalf % 2 == 0 && i % 2 == 0) {
                cout << "YES\n";
                return 0;
            }
            otherHalf--;
        }
        cout << "NO\n";
    }
    
    return 0;
}
