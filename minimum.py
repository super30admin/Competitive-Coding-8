# The minWindow method finds the minimum window substring in `s` that contains all characters of `t`.

# Count characters in `t` using a dictionary (`countT`).
# Use a sliding window with two pointers (`l` and `r`) and a `window` dictionary to track characters in the current window.
# - Expand the window by moving `r` and updating `window`.
# - When the window satisfies the character counts in `t` (`have == required`):
#   - Update the result if the current window is smaller than the previous smallest.
#   - Shrink the window from the left (`l`) to explore smaller valid windows.

# Return the smallest valid substring or an empty string if no such window exists.

# TC: O(m + n) - m for building `countT`, n for traversing `s`.
# SC: O(m + n) - Space for `countT` and `window`.


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""

        countT, window = {}, {}
        for c in t:
            countT[c] = 1 + countT.get(c, 0)

        required = len(countT)
        have = 0
        res = [-1, -1]
        resLen = float("infinity")

        l = 0

        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)

            if c in countT and window[c] == countT[c]:
                have += 1

            while required == have:
                if (r - l + 1) < resLen:
                    res = [l, r]
                    resLen = r - l + 1

                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1

                l += 1
        l, r = res
        if resLen != float("infinity"):    
            res = s[l:r+1]
            return res
        else:
            return "" 