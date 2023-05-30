#include <bits/stdc++.h>

using namespace std;

int log5(int n) {
    return log2f(n) / log2f(5);
}

int polignacFormula(int n) {
    int k = log5(n);

    int currDiv = 5;
    int res = 0;

    for (int i = 0; i < k; i++) {
        res += (n/currDiv);
        currDiv *= 5;
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n; cin >> n;

    cout << polignacFormula(n);

    return 0;
}

