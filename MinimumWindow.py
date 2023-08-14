#All TC on leetocde passed


class Solution:
    def minWindow(self, s: str, t: str) -> str:

        #Here we use sliding window to find the t string in s
        #Time complexity - O(n) - traverse all chars of string s
        #Space complexity - O(1) - as max chars are only 52 alphabets
        t_map = collections.defaultdict(int)
        s_map = collections.defaultdict(int)
        

        for ch in t:
            t_map[ch]+=1

        matched = len(t_map)
        formed = 0

        res = ""
        resLen = 0

        l=0
        r=0

        while l<=r and r<len(s):

            ch = s[r]

            if ch in t_map:
                s_map[ch]+=1
            
            if ch in t_map and t_map[ch]==s_map[ch]:
                formed+=1
        
            
            while l<=r and formed==matched:

                ch = s[l]

                if res=="" or len(res)>(r-l+1):
                    res = s[l:r+1]
                
                if ch in t_map:
                    s_map[ch]-=1
                
                if ch in t_map and t_map[ch]>s_map[ch]:
                    formed-=1
                
                l+=1
            r+=1
            
        return res


        