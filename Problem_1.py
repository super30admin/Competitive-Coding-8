# https://leetcode.com/problems/minimum-window-substring/description/

# Time complexity: O(S + T), where S and T are the sizes of the strings s and t respectively
# Space complexity: O(S + T)
# Explanation: Use a sliding window to find the maximum possible window, and keep shrinking.
# To reduce the search space, we can first create a new array from s with the chars which are in t, with their indices

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not t or not s:
            return ""
        
        dict_t = Counter(t)
        required = len(dict_t)
        
        filtered_s = []
        for i, ch in enumerate(s):
            if ch in dict_t:
                filtered_s.append((i, ch))
        
        l, r = 0, 0
        formed = 0
        counts = {}

        ans = float("inf"), None, None

        while r < len(filtered_s):
            curr = filtered_s[r][1]
            counts[curr] = counts.get(curr, 0) + 1

            if counts[curr] == dict_t[curr]:
                formed += 1
            
            while l <= r and formed == required:
                curr = filtered_s[l][1]
                start = filtered_s[l][0]
                end = filtered_s[r][0]
                
                if end - start + 1 < ans[0]:
                    ans = (end - start + 1, start, end)
                
                counts[curr] -= 1
                if counts[curr] < dict_t[curr]:
                    formed -= 1
                l += 1
            
            r += 1
        
        return "" if ans[0] == float("inf") else s[ans[1] : ans[2] + 1]
