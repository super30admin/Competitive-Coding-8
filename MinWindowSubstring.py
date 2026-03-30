# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : So we first build a frequency map of t and then use a sliding window to find matching characters in s.
# When we match all characters, we shrink from the left to get the smallest valid window.
# If the current window is smaller than the previous best, we update the answer.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = Counter(t)
        missing = len(t)
        start = left = end = 0

        for right, ch in enumerate(s, 1):
            if need[ch] > 0:
                missing -= 1
            need[ch] -= 1

            if missing == 0:
                while left < right and need[s[left]] < 0:
                    need[s[left]] += 1
                    left += 1

                if end == 0 or right - left < end - start:
                    start, end = left, right

                need[s[left]] += 1
                left += 1
                missing += 1
            
        return s[start:end]
        