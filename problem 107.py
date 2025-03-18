#  https://leetcode.com/problems/minimum-window-substring/

class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""

        hm_t = {}
        for i in range(len(t)):
            if t[i] not in hm_t:
                hm_t[t[i]] = 0
            hm_t[t[i]] += 1
        
        match = 0
        l = 0
        r = 0
        ans = [-1,0,0] # len of string, l, r
        required = len(hm_t)

        windowcount = defaultdict(int)

        while r < len(s):
            c = s[r]

            count = windowcount.get(c,0)
            windowcount[c] = count+1

            if c in hm_t and hm_t[c] == windowcount[c]:
                match+=1
            
            while l<=r and match == required:
                ch = s[l]

                if ans[0] == -1 or r-l+1 < ans[0]:
                    ans[0] = r-l+1
                    ans[1] = l
                    ans[2] = r
                windowcount[ch] -= 1

                if ch in hm_t and windowcount[ch] < hm_t[ch]:
                    match-=1
            
                l+=1
            r+=1
        
        if ans[0] == -1:
            return ""
        else:
            return s[ans[1]:ans[2]+1]
            #return ans[2] - ans[1] + 1

# TC: O(n) n is the length of s
# SC: O(k) k is the len of the windowcount