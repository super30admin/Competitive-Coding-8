#time: O(n)
#space: O(1)
from collections import defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        cmap=Counter(t)
        wmap=Counter()
        l=0
        r=1
        n=len(s)
        mn=s[-1:-1]
        ml=n+1
        mach=0
        for r,char in enumerate(s):
            #add char to windowmap
            wmap[char]+=1
            if char in cmap and wmap[char]== cmap[char]:
                mach+=1
            while mach >= len(cmap):
                if (r-l+1) < ml:
                    ml=r-l+1
                    mn=s[l:r+1]
                wmap[s[l]]-=1
                if wmap[s[l]] < cmap[s[l]]:
                    mach-=1
                l+=1
        return mn
