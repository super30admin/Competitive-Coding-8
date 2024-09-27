# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        n=len(s)
        m=len(t)
        result=s
        if m>n: return ""
        hash_map={}
        for i in range(m):
            if t[i] not in hash_map:
                hash_map[t[i]]=0
            hash_map[t[i]]+=1
        mapp=hash_map
        match=0
        f=False
        slow=0
        for i in range(n):
            if s[i] in mapp:
                mapp[s[i]]-=1
                if mapp[s[i]]==0:
                    match+=1
            while match==len(mapp):
                f=True
                if len(s[slow:i+1])<len(result):result=s[slow:i+1]
                if s[slow] in mapp:
                    mapp[s[slow]]+=1
                    if mapp[s[slow]]==1:
                        match-=1
                slow+=1
        if f: return result
        else: return ""
                    
                    

            
                
            
        