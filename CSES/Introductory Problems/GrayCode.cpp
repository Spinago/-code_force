#include <bits/stdc++.h>

using namespace std;

string getBinary(int n, int size) {
    if (n == 0) return "0";
    string s = "";

    while (n > 0) {
        s = (n & 1 ? '1' : '0') + s;
        n >>= 1;
    }

    return s;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n; cin >> n;
    for (int i = 0; i < pow(2, n); i++) {
        int mask = 1 << (n - 1);
        int res = i & mask;

        int pos = n - 1;
        while (mask > 1) {
            bool k0 = i & mask, k1 = i & (mask >> 1);
            int bit = k0 ^ k1;
            mask >>= 1;
            res |= bit << (--pos);
        }
        string binary = getBinary(res, n);

        for (int i = 0; i < n - binary.length(); i++) {
            cout << "0";
        }
        

        cout << binary << "\n";
    }

    return 0;
}