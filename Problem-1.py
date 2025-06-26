'''
    Time Complexity: O(m + n)
    Space Complexity: O(1)
'''
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        w_map = {}
        t_map = {}
        have = need = 0
        result = None

        # Creationg of maps
        for char in t:
            if char not in t_map:
                t_map[char] = 1
                w_map[char] = 0
                need += 1
            else:
                t_map[char] += 1

        return self.checkSubstring(s, t, w_map, t_map, have, need, result, len(s))

    def checkSubstring(self, s, t, w_map, t_map, have, need, result, n):
        left = 0

        for right in range(n):
            if s[right] in w_map:
                char = s[right]
                w_map[char] += 1

                if w_map[char] == t_map[char]:
                    have += 1

                while have == need:
                    if not result or right - left + 1 < result[1] - result[0] + 1:
                        result = [left, right]

                    out_char = s[left]
                    left += 1

                    if out_char in w_map:
                        w_map[out_char] -= 1

                        if w_map[out_char] < t_map[out_char]:
                            have -= 1

        return s[result[0]:result[1]+1] if result else ""