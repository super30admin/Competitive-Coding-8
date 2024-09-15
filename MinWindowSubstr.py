"""
Given two strings s and t of lengths m and n respectively, 
return the minimum window substring of s such that every character in t (including duplicates) 
is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
"""

# Time Complexity : O(m)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        # null case
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""
        
        # logic
        map1 = {}
        
        for i in t:
            if i not in map1:
                map1[i] = 1
            else:
                map1[i] += 1
                
        match = 0
        temp = float("inf")
        i, j = 0, 0
        res = ""
        
        while i <= j and i < len(s):
            if match == len(map1):
                temp = min(temp, j-i)
                if temp == j-i:
                    res = s[i:j]

            if(i != j and match == len(map1)) or j == len(s):
                if s[i] in map1:
                    if map1[s[i]] == 0:
                        match -= 1
                    map1[s[i]] += 1
                i += 1
            else:
                if s[j] in map1:
                    if map1[s[j]] == 1:
                        match += 1
                    map1[s[j]] -= 1
                j += 1
        return res
                        
            
                
                