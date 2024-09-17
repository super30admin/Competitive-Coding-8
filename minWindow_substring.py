class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        TC:O(n)
        SC:O(const), for creating hashmaps
        
        """
        
        if not s or not t: return ""
        dt={}
        for i in range(len(t)):
            dt[t[i]]=dt.get(t[i],0)+1
        print(dt)
        
        size = len(dt)
        l=0
        r=0
        formed=0
        window={}
        res=[-1,""]
        while r<len(s):
            # incoming condn
            if s[r] in window:
                window[s[r]]+=1
            else:
                window[s[r]]=1
            if s[r] in dt:
                if dt[s[r]]==window[s[r]]:
                    formed+=1
                #outgoing conidtion 
                while l<=r and formed==size:
                    if res[0]>r-l+1 or res[0]==-1:
                        res[0]=r-l+1
                        res[1]=s[l:r+1]
                    window[s[l]]-=1
                    if s[l] in dt and window[s[l]]<dt[s[l]]:
                        formed-=1
                    l+=1
            r+=1
        return res[1]
        
    