#time:  O(mn) m = len(t) and n = len(s)
#space: O(n)

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if(t=="" or len(t)>len(s)):
            return ""
        hashmap={}
        for i in t:
            if  i not in hashmap:
                hashmap[i]=1
            else:
                hashmap[i]+=1
        def checkmap(hashmap):
            for i in hashmap:
                if(hashmap[i]>0):
                    return False
            return True
        start=0
        end=0
        finalend=float("inf")
        finalstart=0
        prev=-1
        while(end<len(s)):
            if(prev<end):
                endc=s[end]
                if endc in hashmap:
                    hashmap[endc]-=1
            prev=end
            
            if(checkmap(hashmap)):
                if(finalend-finalstart>end-start):
                    finalend=end
                    finalstart=start
                startc=s[start]
                start+=1
                if startc in hashmap:
                    hashmap[startc]+=1
            else:
                end+=1
        if(finalend==float("inf")):
            return ""
        else:
            return s[finalstart:finalend+1]
        