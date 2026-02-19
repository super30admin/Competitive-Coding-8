''' Time Complexity : O(n) 
    Space Complexity : O(1) : only 26 char for both hashmap
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        thash = {}
        shash = {}
        for c in t:
            thash[c] = thash.get(c,0) + 1
        maxlen = float("inf")
        res = ""
        need=len(thash)
        match = 0
        l = 0
        for r in range(len(s)):
            c = s[r]
            if c in t:
                shash[c] = shash.get(c,0) + 1
                if shash[c] == thash[c]:
                    match += 1
            
            while l <= r and match == need:
                newlen = (r - l) + 1
                if newlen < maxlen:
                    maxlen = newlen
                    res = s[l:r+1]

                if s[l] in thash:
                    shash[s[l]] -= 1
                    if shash[s[l]] < thash[s[l]]:
                        match -= 1
                l += 1
        return res
            









       