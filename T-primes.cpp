#include <bits/stdc++.h>
using namespace std;

bool is_prime(int);

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    long long c;
    
    while (cin>>n)
    {
        for (int i=0; i<n; i++)
        {
            cin>>c;
            
            if ((c%2 == 0 && c != 4) || floor(sqrt(c)) != sqrt(c))
            {
                cout<<"NO\n";
                continue;
            }
            
            if (is_prime(sqrt(c)) || c==4)
                cout<<"YES\n";
            else
                cout<<"NO\n";
            
        }
    }
    
    return 0;
}


bool is_prime(int n)
{
    
    if (n<=1)
        return false;
    if (n<=3)
        return true;
    if (n%2 == 0 || n%3 == 0)
        return false;
    
    for (int i=5; i*i <= n; i+=6) {
        if (n%i == 0 || n%(i+2) == 0)
            return false;
    }
    
    return true;
}
