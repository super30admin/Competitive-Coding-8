# TC : O(len(s)) + O(len(t))
# SC : O(len(s)) + O(len(t))

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        t_map = {}
        for ch in t:
            if ch not in t_map:
                t_map[ch] = 0
            t_map[ch] += 1

        min_len = float("inf")
        left_index = None
        match_count = 0
        window_map = {}
        required_match_count = len(t_map)

        j = 0
        for i in range(0,len(s)):
            if s[i] in t_map:
                if s[i] not in window_map:
                    window_map[s[i]] = 0
                window_map[s[i]] += 1

            if s[i] in t_map and window_map[s[i]] == t_map[s[i]]:
                match_count += 1

            while j <= i and match_count == required_match_count:
                if i - j + 1 < min_len:
                    min_len = i - j + 1
                    left_index = j
                ch = s[j]
                if ch in t_map:
                    window_map[ch] -= 1
                if ch in t_map and window_map[ch] < t_map[ch]:
                    match_count -= 1
                j += 1

        if min_len == float("inf"):
            return ""
        else:
            return s[left_index:left_index+min_len]


