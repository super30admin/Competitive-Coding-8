# // Time Complexity :O(m+n)
# // Space Complexity :O(m+n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        hmapt={}
        for i in range(len(t)):
            if t[i] not in hmapt.keys():
                hmapt[t[i]]=0
            hmapt[t[i]]+=1
        required=len(hmapt)
        l=0
        r=0
        formed=0
        hmaps={}
        ans=[-1,l,r]
        while r<len(s):
            print(s[r])
            if s[r] not in hmaps.keys():
                hmaps[s[r]]=0
            hmaps[s[r]]+=1
            if s[r] in hmapt.keys() and hmapt[s[r]]==hmaps[s[r]]:
                formed+=1
            while formed==required and l<=r:
                if ans[0]==-1 or r-l+1<ans[0]:
                    ans[0]=r-l+1
                    ans[1]=l
                    ans[2]=r
                    
                c=s[l]
                if hmaps[s[l]]:
                    hmaps[s[l]]+=-1
                if s[l] in hmapt.keys() and hmaps[s[l]]<hmapt[s[l]]:
                    formed-=1
                l+=1
            r+=1
        print(ans)
        print(s[ans[1]])
        if ans[0]==-1:
            return ""
        else:
            return s[ans[1]:ans[2]+1]
            
            