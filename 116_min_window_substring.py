# Time complexity - O(s + t)
# Space complexity - O(s + t)

# Approach - Maintain a hashmap with all the {char: count}. While i stays in the limit, if match equals
# len(hashmap) means we found our substring, else if we're at the end of s, if hashmap[s[i]] == 0,
# decreement match by 1, else if hashmap[s[i]] == 1, increement match by 1.

import sys 
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""

        hashMap = {}

        for i in t:
            if i not in hashMap:
                hashMap[i] = 0
            hashMap[i] += 1
        
        match = 0
        temp = sys.maxsize
        i, j = 0, 0
        out = ""

        while i <= j  and i < len(s):
            if match == len(hashMap):
                temp = min(temp, j-i)
                if temp == j - i:
                    out = s[i:j]

            if (match == len(hashMap)) or j == len(s):
                if s[i] in hashMap:
                    if hashMap[s[i]] == 0:
                        match -= 1
                    hashMap[s[i]] += 1
                i += 1
            else:
                if s[j] in hashMap:
                    if hashMap[s[j]] == 1:
                        match += 1
                    hashMap[s[j]] -= 1
                j += 1
        return out