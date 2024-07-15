# Time Complexity : O(m+n), where m is the length of string s and n is the length of string t
# Space Complexity : O(n)

from collections import defaultdict

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or len(s) < len(t):
            return ""

        map_t = defaultdict(int)

        for c in t:
            map_t[c] += 1

        n = len(map_t)
        start = 0
        end = 0
        min_length = float('inf')
        i = 0

        while end < len(s):
            ch = s[end]
            if ch in map_t:
                map_t[ch] -= 1
                if map_t[ch] == 0:
                    n -= 1
            end += 1

            while n == 0:
                temp = s[start]
                if temp in map_t:
                    map_t[temp] += 1
                    if map_t[temp] > 0:
                        n += 1

                if end - start < min_length:
                    min_length = end - start
                    i = start
                start += 1

        if min_length == float('inf'):
            return ""

        return s[i:i + min_length]

# Example 1

s = "ADOBECODEBANC"
t = "ABC"
sol = Solution()
print(sol.minWindow(s, t)) # Output : "BANC"

# Example 2

s = "a"
t = "a"
sol = Solution()
print(sol.minWindow(s, t)) # Output : "a"

# Example 3

s = "a"
t = "aa"
sol = Solution()
print(sol.minWindow(s, t)) # Output : ""