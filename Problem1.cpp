// Problem Name: Minimum Window Substring
//  Time Complexity : O(n)
//  Space Complexity : O(k) where k is length of string t
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No, just a couple of edge cases

// Your code here along with comments explaining your approach
// 1. We take a sliding window aproach here, where we start our window at 0
// 2. We maintain a uniq count of chars, once it reaches zero, we try to shrink
// our window
// 3. We keep updating the windowLen and start, and in the end return the
// substring
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  string minWindow(string s, string t) {
    if (t.size() > s.size())
      return "";
    unordered_map<char, int> tMap;
    for (auto it : t) {
      tMap[it]++;
    }

    int n = (int)s.size();
    int uniq = (int)tMap.size();
    int i = 0;
    int j = 0;
    int start = 0;
    int windowLen = INT_MAX;

    while (j < n) {
      if (tMap.count(s[j]) > 0) {
        tMap[s[j]]--;
        if (tMap[s[j]] == 0) {
          uniq--;
        }
      }
      if (uniq == 0) {
        while (uniq == 0) {
          if (j - i + 1 < windowLen) {
            start = i;
            windowLen = j - i + 1;
          }
          if (tMap.count(s[i]) > 0) {
            tMap[s[i]]++;
            if (tMap[s[i]] == 1) {
              uniq++;
            }
          }
          i++;
        }
      }
      j++;
    }

    return windowLen == INT_MAX ? "" : s.substr(start, windowLen);
  }
};
