"""
TIME - O(N+M)
SPACE - O(N+M)
"""

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""

        dic = {}     # TO KEEP COUNT OF given pattern t
        wind_count = {}            # to keep count of window
        l = 0
        r = 0
        formed = 0       #window formed size
        ans = float("inf"), None, None    #tuple to store ans, l , r

        for i in range(len(t)):       # count t and create dic
            if t[i] in dic:
                dic[t[i]] += 1
            else:
                dic[t[i]] = 1
        print(len(dic))
        required = len(dic)     #size

        while r < len(s):
            wind_count[s[r]] = wind_count.get(s[r], 0) + 1   # add char in wind_count dictionary

            if s[r] in dic and dic[s[r]] == wind_count[s[r]]:                 #if same char and count is same
                formed += 1

            while l <= r and formed == required:      # reduce from left
                if r - l + 1 < ans[0]:
                    ans = (r - l + 1, l, r)    # store ans in tuple
                wind_count[s[l]] -= 1     # reduce window size
                if s[l] in dic and wind_count[s[l]] < dic[s[l]]:   # if count in window is less than dic formed window -1
                    formed -= 1

                l += 1
            r += 1
        return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]






