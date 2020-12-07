#Time: O(N)
#Space: O(len(t))

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        char_freq={}
        ws=0
        min_len= float("inf")
        matched=0
        
        for ch in t:
            if ch not in char_freq:
                char_freq[ch]=1
            else:
                char_freq[ch]+=1
            
        for we in range(len(s)):
            rc = s[we]
            if rc in char_freq:
                char_freq[rc]-=1
                
                if char_freq[rc]>=0:
                    matched+=1
            
            while matched == len(t):
                if min_len > we-ws+1:
                    min_len=we-ws+1
                    sub_str = ws #to keep track of starting of sub string
                
                out_char = s[ws]
                ws+=1
                if lc in char_freq:
                    if char_freq[out_char] == 0:
                        matched-=1
                    char_freq[out_char]+=1
                    
        if min_len > len(s):
            return ""
        return s[sub_str:sub_str + min_len]
