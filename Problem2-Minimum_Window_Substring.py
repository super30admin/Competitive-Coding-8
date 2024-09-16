#TC and SC is O(n) 

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        minLength=float('inf')
        startIndex=-1
        l,r=0,0
        count=0
        hhash={}

        for i in range(len(t)):
            if t[i] in hhash:
                hhash[t[i]]+=1
            else:
                hhash[t[i]]=1
            
        while r<len(s):
            if s[r] in hhash:
                if hhash[s[r]]>0:
                    count+=1
            else:
                hhash[s[r]]=0
            hhash[s[r]]-=1


            while count==len(t):
                hhash[s[l]]+=1
                if r-l+1<minLength:
                    minLength=r-l+1
                    startIndex=l
                if hhash[s[l]]>0:
                    count-=1
