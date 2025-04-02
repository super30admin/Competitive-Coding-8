from collections import Counter, defaultdict


class Solution:
    # sliding window technique
    # TC: O(m+n)
    # SC: O(m+n)
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t or len(s) < len(t):
            return ""

        ct = Counter(t)  # Character frequency in t
        cs = defaultdict(int)  # Character frequency in current window

        left, min_len, res = 0, float('inf'), ""
        required = len(ct)  # Unique characters in t
        formed = 0  # Unique characters in current window that match t

        for right in range(len(s)):
            cs[s[right]] += 1
            if cs[s[right]] == ct[s[right]]:
                formed += 1

            while formed == required:
                window_len = right - left + 1
                if window_len < min_len:
                    min_len = window_len
                    res = s[left:right + 1]

                # Shrink the window from the left
                cs[s[left]] -= 1
                if cs[s[left]] < ct[s[left]]:
                    formed -= 1
                left += 1

        return res