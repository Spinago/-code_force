#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    double n, m, a;
    cin >> n >> m >> a;
    
    cout << fixed << setprecision(0) << ceil(n / a) * ceil(m / a);
    
    return 0;
}
