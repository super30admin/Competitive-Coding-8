class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(t) > len(s):
            return ""
        countT = {}
        window_string = {}
        res_len = float("inf")
        res = [-1, -1]
        have = 0

        for c in t:
            countT[c] = 1 + countT.get(c, 0)
        need = len(countT)

        l = 0

        for r in range(len(s)):
            char = s[r]
            window_string[char] = 1 + window_string.get(char, 0)

            if char in countT and window_string[char] == countT[char]:
                have += 1

            while have == need:
                if r - l + 1 < res_len:
                    res_len = r - l + 1
                    res = [l, r]

                window_string[s[l]] -= 1

                if s[l] in countT and window_string[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
        l, r = res
        return s[l : r + 1]


# time complexity is O(n)
# space complexity is O(n)
