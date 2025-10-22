# Time is O(n) using the sliding window strategy.
# Space is O(1) as tmap and smap can only have lower and uppercase characters which are constant

# The intuition here to keep track of have vs need. If it equals then we can shorten the window to get the min substring.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s): return ""
        left = 0
        right = 0
        minLeft = 0
        minRight = 0
        tMap = Counter(t)
        sMap = {}
        minLength = float("inf")
        have, need = 0, len(tMap)

        while right < len(s):
            if s[right] in tMap:
                if s[right] in sMap:
                    sMap[s[right]] += 1
                else:
                    sMap[s[right]] = 1
                if sMap[s[right]] == tMap[s[right]]:
                    have += 1

            while have == need:
                currLength = right - left + 1
                if currLength < minLength:
                    minLeft = left
                    minRight = right
                    minLength = currLength
                if s[left] in sMap:
                    sMap[s[left]] -= 1
                    if s[left] in tMap and sMap[s[left]] < tMap[s[left]]:
                        have -= 1
                left += 1

            right += 1

        return "" if minLength == float("inf") else s[minLeft: minRight + 1]