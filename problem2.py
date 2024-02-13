#Time Complexity : O(n), where n is the length of the string s
#Space Complexity :O(m), where m is the length of the string t
#Did this code successfully run on Leetcode : yes

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == " ":
            return ""
            
        countT, window = {}, {}
        for c in t:
            countT[c] = 1+ countT.get(c,0)
        
        have = 0
        need = len(countT)
        result = [-1,-1]
        resLen = float('inf')

        l = 0
        for r in range(len(s)):
            c = s[r]
            window[c] = 1+ window.get(c,0)

            if c in countT and window[c] == countT[c]:
                have += 1
            
            while have == need:
                if(r-l+1) < resLen:
                    result = [l,r]
                    resLen = r-l+1
                window[s[l]] -= 1

                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
            
        l, r = result[0], result[1]
        return s[l:r+1] if resLen != float('inf') else ""

        