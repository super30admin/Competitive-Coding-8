"""
TC: O(m+n)
SC: O(1)
Logic:
Use 2 pointer method.
"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l = 0
        r = 0
        start = -1
        min_length = float('inf')
        match = 0

        tMap = Counter(t)
        while(r<len(s)):
            rChar = s[r]
            if rChar in tMap:
                tMap[rChar] = tMap[rChar]-1
                if tMap[rChar] == 0:
                    match+=1
            while(match == len(tMap)):
                if r-l+1<min_length:
                    min_length = r-l+1
                    start = l
                lChar = s[l]
                if lChar in tMap:
                    tMap[lChar] = tMap[lChar]+1
                    if tMap[lChar]>0:
                        match-=1
                l+=1
            r+=1
        return s[start:start+min_length] if start!=-1 else ""