// Time Complexity : O(M+N) 

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Storing string t in hashmap, and iterating over string s using sliding window
// technique by processing one char and leaving out the other.

// 76. Minimum Window Substring

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        int m = s.length();
        int n = t.length();
        int minLen = INT_MAX;
        int ansLen = 0;
        string ans = "";
        unordered_map<char,int> mp;
        for(auto t1 : t){
            mp[t1]++;
        }
        int start = 0, end = 0, match = 0;
        int minStart = 0; // Start index of the minimum window
        while(end < m){
            char in = s[end];
            if(mp.find(in) != mp.end()){
                int count = mp[in];
                count--;
                if(count == 0){
                    match++;
                }
                mp[in] = count;
            }
            end++;
            while(match == mp.size()){
                if(minLen > end - start){
                    minLen = end - start;
                    minStart = start; 
                }
                if(mp.find(s[start]) != mp.end()){
                    int count = mp[s[start]];
                    count++;
                    if(count > 0){
                        match--;
                    }
                    mp[s[start]] = count;
                }
                start++;
            }
        }
        if(minLen != INT_MAX){
            ans = s.substr(minStart, minLen); 
        }
        return ans;
    }
};