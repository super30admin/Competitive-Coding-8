class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) == 0 or len(t) == 0:
            return ""
        tmap = {}
        for i in range(len(t)):
            tmap[t[i]] = tmap.get(t[i], 0) + 1
        smap = {}
        l, r = 0, 0
        formed = 0
        ans = [-1, 0, 0]
        required = len(tmap)
        while r < len(s):
            smap[s[r]] = smap.get(s[r], 0) + 1
            if s[r] in tmap.keys() and smap[s[r]] == tmap[s[r]]:
                formed += 1
            while l <= r and formed == required:
                if ans[0] == -1 or ans[0] > r - l + 1:
                    ans[0] = r - l + 1
                    ans[1] = l
                    ans[2] = r
                smap[s[l]] -= 1
                if s[l] in tmap.keys() and tmap[s[l]] > smap[s[l]]:
                    formed -= 1
                l += 1
            r += 1
        return '' if ans[0] == -1 else s[ans[1]: ans[2] + 1]

# Time Complexity: O( len(s) + len(t))
# Space Complexity: O(1)