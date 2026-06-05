# https://leetcode.com/problems/minimum-window-substring/description/

class Solution:
    def minWindow(self, s, t):
        ls, lt = len(s), len(t)
        if ls < lt:
            return ""
        startIndex = -1
        minLen = ls + 1
        t_map = {}
        for c in t:
            t_map[c] = t_map.get(c,0)+1
        left = 0
        matchcount = 0
        for right in range(ls):
            incoming = s[right]
            if incoming in t_map:
                t_map[incoming] -= 1
                if t_map[incoming] == 0:
                    matchcount += 1

            while matchcount == len(t_map):
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    startIndex = left
                outgoing = s[left]
                left += 1
                if outgoing in t_map:
                    t_map[outgoing] += 1
                    if t_map[outgoing] == 1:
                        matchcount -= 1

        if startIndex == -1:
            return ""
        return s[startIndex : startIndex + minLen]
