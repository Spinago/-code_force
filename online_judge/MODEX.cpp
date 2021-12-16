#include <iostream>

#define ll long long

ll modbinpow(ll a, ll n, ll m) {
    a %= m;
    ll res = 1;
    
    while (n > 0) {
        if (n & 1) {
            res = res * a % m;
        }
        
        a = a * a % m;
        
        n >>= 1;
    }
    
    return res;
}

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    
    int c; cin >> c;
    
    for (int i = 0; i < c; i++) {
        ll a, n, m; cin >> a >> n >> m;
        
        cout << modbinpow(a, n, m) << "\n";;
    }
    
    return 0;
}

