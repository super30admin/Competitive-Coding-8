#time O(M+N)
#space: O(M+N)

from collections import defaultdict
import sys
#-sys.maxsize-1
class Solution:
    def minWindow(self, s: str, target: str) -> str:
        
        countT = Counter(target)
        window = defaultdict(int,{})
        
        have, need = 0, len(countT)
        res, resLen = [-1,-1], sys.maxsize
        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] += 1
            
            if c in countT and countT[c] == window[c]:
                have += 1
                
            while have == need: #while, becausewe will shrink the window to min
                if (r - l + 1) < resLen:
                    res = [l,r]
                    resLen = r-l+1
                #pop left from window
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
        l,r = res
        return s[l:r+1] if resLen != sys.maxsize else ""