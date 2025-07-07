# TC: O(m+n)
# SC: O(m)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        min_win=(-float('inf'),float('inf'))
        min_len=float('inf')
        hmap=Counter(t)
        matched=0
        l=r=0

        while r<len(s):
            if s[r] in hmap:
                hmap[s[r]]-=1
                if hmap[s[r]]==0:
                    matched+=1
            
            while matched==len(hmap):
                if (r-l+1)<min_len:
                    min_win=(l,r)
                    min_len=r-l+1
                if s[l] in hmap:
                    hmap[s[l]]+=1
                    if hmap[s[l]]==1:
                        matched-=1
                
                l+=1
            r+=1
        
        return s[min_win[0]:min_win[1]+1] if min_len != float('inf') else ""


