class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """Dynaic Programming Approach
        Time complexity-O(m+n)
        space complexity-O(n) as using hashmaps for only elements present in t."""
        if len(t)>len(s) :
            return ""
        hashmap={}
        hashmapwindow={}
        maxcount=0
        li=[-1,-1,100000000]
        for i in t:
            if i not in hashmap:
                hashmap[i]=1
            else:
                hashmap[i]+=1
        print(hashmap)      
        start=0
        end=0
        maxcount=0
        while end<len(s):
            if s[end] in hashmap:
                if s[end] not in hashmapwindow:
                    hashmapwindow[s[end]]=1
                else:
                    hashmapwindow[s[end]]+=1
                if hashmapwindow[s[end]]==hashmap[s[end]]:
                    maxcount+=1
                while start<=end and maxcount==len(hashmap):
                    if li[2]>end-start+1:
                        li[0]=start
                        li[1]=end
                        li[2]=end-start+1
                    if s[start] in hashmapwindow and s[start] in hashmap:
                        hashmapwindow[s[start]]-=1
                        if hashmapwindow[s[start]]<hashmap[s[start]]:
                            maxcount-=1
                    start+=1
            end+=1
        return s[li[0]:li[1]+1]
        
                    
            
        