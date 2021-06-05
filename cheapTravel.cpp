#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m, a, b;
    
    while (cin>>n>>m>>a>>b)
    {
        if (m*a <= b)
        {
            cout<<a*n;
            continue;
        }
        
        int p = 0;
        
        p += (n/m)*b;
        n = n%m;
        
        if (a*n <= b)
            p += a*n;
        else
            p += b;
        
        cout<<p;
    }
    
    return 0;
}
