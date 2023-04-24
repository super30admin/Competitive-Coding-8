# TC : O(N+M)
# SC : O(M)

import collections

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        d=collections.Counter(t)
        c=len(d)
        i=start=0
        n=len(s)
        ans=n+1
        for j in range(n):
          # print(d, c)
          if s[j] in d:
              d[s[j]]-=1
              if d[s[j]]==0:
                  c-=1   
          print(d, s[j], c)        
          while c==0:
            if ans>j-i+1:
                ans=j-i+1
                start=i
            if s[i] in d:
                d[s[i]]+=1
                if d[s[i]]>0:
                    c+=1
            i+=1
        if ans>n:
            return ""
        return s[start:start+ans]