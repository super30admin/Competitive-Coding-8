"""76. Minimum Window Substring

Time Complexity: O(s+t)  
Space Complexity: O(s+t)"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t)==0 or len(s)==0:
            return""
        
        tmap, window = {}, {}
        for ele in t:
            tmap[ele] = 1 + tmap.get(ele, 0)
        
        have, need = 0, len(tmap)
        res, resLen = [-1, -1], float("infinity")
        l = 0
        r = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)
            
            if c in tmap and window[c] == tmap[c]:
                have += 1
        
            while have == need:
                # update our result
                if (r - l + 1) < resLen:
                    res = [l, r]
                    resLen = (r - l + 1)
                # pop from the left of our window
                window[s[l]] -= 1
                if s[l] in tmap and window[s[l]] < tmap[s[l]]:
                    have -= 1
                l += 1
        l, r = res
        return s[l:r+1] if resLen != float("infinity") else ""
                
                    
            