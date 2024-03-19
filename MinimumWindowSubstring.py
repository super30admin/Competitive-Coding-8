'''
TC: O(n) - going through the length of the string and we have 
            established t is smaller than s always
SC: O(1) - since we are using 2 dictionaries of alphabets so can only have 
            26+26 = 52 characters (uppercase and lowercase included) 
                    - which gives us constant space
'''
import collections

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t)>len(s):
            return ""
        sdict = collections.defaultdict(int)
        tdict = collections.defaultdict(int)

        for a in t:
            tdict[a] += 1
        need = len(tdict)
        have = 0
        start,end = None, None
        resCount = float('inf')

        l,r = 0,0
        while r<len(s):
            if s[r] in tdict:
                sdict[s[r]]+=1
                if sdict[s[r]] == tdict[s[r]]:
                    have += 1
                    while have == need:
                        if resCount > (r-l+1):
                            start,end = l,r
                            resCount = min(resCount, r-l+1)
                        if s[l] in sdict:
                           sdict[s[l]]-=1
                           if sdict[s[l]] < tdict[s[l]]:
                            have -= 1
                            if resCount > (r-l+1):
                                start,end = l,r
                                resCount = min(resCount, r-l+1)
                        l+=1
            r+=1
        res = ""
        if start == None and end == None:
            return res
        for i in range(start, end+1):
            res+=s[i]
        return res
s = Solution()
print(s.minWindow("ADOBECODEBANC", "ABC"))
print(s.minWindow("a", "a"))
print(s.minWindow("a", "aa"))
print(s.minWindow("cabwefgewcwaefgcf", "cae"))
print(s.minWindow("a", "b"))