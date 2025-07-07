# // Time Complexity : o(n) length of string s
# // Space Complexity : maps o(m)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# idea is to have a window  tocount the no of distinct characters from tmap that have been seen now maintain the min count and move the window by removing one character from end

from typing import collections
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tmap = collections.Counter(t)
        smap = {}
        have , needed= 0,len(tmap)
        l ,res,reslen= 0 ,[-1,-1], float("inf")
        for i in range(len(s)):
            c = s[i]
            smap[c] = smap.get(c,0)+1
            if c in tmap and smap[c] == tmap[c]:
                have+=1
            while have == needed:
                if i-l+1<reslen:
                    reslen = i-l+1
                    res = [l,i]

                smap[s[l]]-=1
                if s[l] in tmap and smap[s[l]]<tmap[s[l]]:
                    have-=1
                l+=1
        l,r= res
        return s[l:r+1] if reslen!=float("inf") else ""


        