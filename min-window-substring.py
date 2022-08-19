"""
Runtime Complexity:
O(s)-We run a while loop through entire string using two pointers. We iterate over all the elements of s an check in the hashmap which is a constant operation.
Space Complexity:
O(t) - because we put each character of 't' string. If there is no substring in s then we might end up with hashmap of capacity 't'.
Yes, the code worked on leetcode.
Issues while coding - No
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s)==0 or len(t)==0 or len(s)<len(t):
            return ""
        h_map = {}
        for i in t:
            if i not in h_map:
                h_map[i] = 0
            h_map[i]+=1
        match = 0
        temp = 999999999
        i , j = 0,0
        out = ""
        
        while i<=j and i<len(s):
            if match == len(h_map):
                temp = min(temp,j-i)
                if temp == j-i:
                    out = s[i:j]
            
            if (i!=j and match == len(h_map)) or j==len(s):
                if s[i] in h_map:
                    if h_map[s[i]]==0:
                        match-=1
                    h_map[s[i]]+=1
                i+=1
            else:
                
                if s[j] in h_map:
                    if h_map[s[j]]==1:
                        match+=1
                    h_map[s[j]]-=1
                j+=1
        return out
        