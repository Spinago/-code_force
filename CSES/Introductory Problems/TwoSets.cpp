#include <bits/stdc++.h>

#define ll long long

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    ll n; cin >> n;

    ll sum = n * (n + 1) / 2;

    if (sum % 2 != 0) {
        cout << "NO";
        return 0;
    }

    ll curr_sum = sum / 2;

    vector<ll> a, b;

    for (ll i = n; i >= 1; i--) {
        if (i <= curr_sum) {
            
            a.push_back(i);
            curr_sum -= i;
        } else {
            b.push_back(i);
        }
    }
    cout << "YES\n" << a.size() << "\n";
    for (ll i : a) {
        cout << i << " ";
    }

    cout << "\n" << b.size() << "\n";
    for (ll i : b) {
        cout << i << " ";
    }


    return 0;
}