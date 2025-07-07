"""
Use a hash map to track character frequency in t
Expand right pointer to grow the window until characters are covered
Shrink the window from the left to find the smallest valid window
"""
"""
Time Complexity - O(n + m) – where n = len(s) and m = len(t)
Space Complexity - O(m) – hash maps for t and the window
"""

from collections import Counter

class minWindowSubstring:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        
        countT = Counter(t)
        window = {}
        have, need = 0, len(countT)
        res, resLen = [-1, -1], float('inf')
        l = 0

        for r in range(len(s)):
            c = s[r]
            window[c] = window.get(c, 0) + 1

            if c in countT and window[c] == countT[c]:
                have += 1

            while have == need:
                if (r - l + 1) < resLen:
                    res = [l, r]
                    resLen = r - l + 1

                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1

        l, r = res
        return s[l:r+1] if resLen != float('inf') else ""

if __name__ == "__main__":
    obj = minWindowSubstring()
    s = "ADOBECODEBANC"
    t = "ABC"
    print(obj.minWindow(s, t))
