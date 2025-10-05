#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
So we first build a frequency map of t and then use a sliding window to find matching characters in s.
When we match all characters, we shrink from the left to get the smallest valid window.
If the current window is smaller than the previous best, we update the answer.
*/
class Solution{
public:
    string minWindow(string s, string t){
        unordered_map<char, int> map;
        for(char c : t){
            map[c]++;
        }
        int len = INT_MAX;
        int start = 0, end = 0;
        int match = 0;
        int slow = 0;

        for(int i = 0; i < s.length(); i++){
            char in = s[i];
            if(map.find(in) != map.end()){
                map[in]--;
                if(map[in] == 0) match++;
            }

            if(match < map.size()) continue;

            while(match == map.size()){
                char out = s[slow];
                slow++;
                if(map.find(out) != map.end()){
                    map[out]++;
                    if(map[out] == 1) match--;
                }
            }

            if(len > i - slow + 2){
                len = i - slow + 2;
                start = slow - 1;
                end = i;
            }
        }
        if(len == INT_MAX) return "";
        return s.substr(start, end - start + 1);
    }
};
