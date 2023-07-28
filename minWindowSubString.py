from collections import Counter, defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ''
        if len(s) < len(t):
            return ''

        dict_t = Counter(t)

        left = right = 0
        found = 0
        window = defaultdict(int)
        minWindow = ''
        while right < len(s):
            if s[right] in dict_t:
                window[s[right]] += 1

            if s[right] in dict_t and window[s[right]] == dict_t[s[right]]:
                found += 1

            while found == len(dict_t):
                if minWindow is '' or right - left + 1 < len(minWindow):
                    minWindow = s[left:right + 1]

                if s[left] in dict_t:
                    window[s[left]] -= 1
                    if window[s[left]] < dict_t[s[left]]:
                        found -= 1
                left += 1
            right += 1

        return minWindow