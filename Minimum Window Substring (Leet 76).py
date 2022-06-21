'''
Using Sliding Window Approach
Time: O(n)
Space: O(1) for hashmap as max 26 alphabets
'''

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if s == '' or len(s) == 0:
            return ''
        
        hm = dict()
        for ch in t:
            if ch not in hm:
                hm[ch] = 1
            else:
                hm[ch] += 1
            
        result = ''
        j = 0
        match = 0
        for i in range(len(s)):
            inc = s[i]
            if inc in hm:
                hm[inc] -= 1
                if hm[inc] == 0:
                    match += 1
            
            while match == len(hm):
                if result == '' or len(result) > len(s[j:i+1]):
                    result = s[j:i+1]
                    
                out = s[j]
                if out in hm:
                    hm[out] += 1
                    if hm[out] == 1:
                        match -= 1
                j += 1
        
        return result