#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    string pokemons[] = {"vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon"};
    vector<string> possiblePokemons;
    
    int n;
    string str;
    cin >> n >> str;
    
    for (int j = 0; j < 8; j++) {
        if (pokemons[j].length() == n) {
            possiblePokemons.push_back(pokemons[j]);
        }
    }
    
    if (possiblePokemons.size() == 1) {
        cout << possiblePokemons.at(0);
        return 0;
    }
    
    
    for (int j = 0; j < possiblePokemons.size(); j++) {
        for (int i = 0; i < str.length(); i++) {
            char letter = str.at(i);
            
            if (letter == '.' || letter == possiblePokemons.at(j).at(i)) {
                if (i + 1 == str.length()) {
                    cout << possiblePokemons.at(j);
                    return 0;
                }
            } else {
                break;
            }
        }
    }
    
    return 0;
}

