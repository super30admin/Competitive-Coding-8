#Time Complexity: O(N)
# Space Complexity: O(N)
# Use a sliding window to keep track of the occurances of a the pattern t in s. Shrink window when all characters are found.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        start = 0
        minlen = float('+inf')
        pattern = collections.Counter(t)
        res = ""
        matched = 0

        for i in range(len(s)):
            endch = s[i]
            if endch in pattern:
                pattern[endch] -= 1
                #seen all the patterns from t
                if pattern[endch] == 0:
                    matched += 1

            #pattern found shrink the window
            while len(pattern) == matched:
                if i - start + 1 < minlen:#end-start+1
                    minlen= i- start + 1
                    res = s[start:i+1]
                startch = s[start]
                start += 1
                if startch in pattern:
                    if pattern[startch] == 0:
                        #character matched
                        matched -= 1
                    pattern[startch] += 1

        return res
        