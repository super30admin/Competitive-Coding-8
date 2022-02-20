'''
TC: O(n)
SC: O(n)
'''
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not t:
            return t
        
        if not s:
            return s
        
        hmap = dict()
        
        for c in t:
            hmap[c] = hmap.get(c, 0) + 1
        
        sl, sr = float("-INF"), float("INF")
        l, r = 0, 0
        c = 0
        tlen = len(t)
        
        while r < len(s):
            if s[r] in hmap:
                hmap[s[r]] -= 1
                if hmap[s[r]] == 0:
                    c += 1
                    
            while c == len(list(hmap.keys())):
                if r - l <= sr - sl:
                    sl, sr = l, r
                if s[l] in hmap and hmap[s[l]] + 1 > 0:
                    break
            
                if s[l] in hmap:
                    hmap[s[l]] += 1
                l += 1
            
            r += 1
            
        if sl == float("-INF"):
            return ""
        
        return s[sl:sr+1]
                 
                
                
        
            