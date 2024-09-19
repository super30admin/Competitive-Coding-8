# Time complexity - O(m+n)
# Space complexity - O(m+n)

from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s) : return ""
        hmap = Counter(t)

        result = s
        indices = []
        start = 0
        matches = 0
        n = len(hmap)
        flag = False
        for i,ch in enumerate(s):
            if ch in hmap:
                hmap[ch] -= 1
                indices.append(i)
                if hmap[ch] == 0:
                    matches += 1
            
            if matches == n :
                idx = indices[start]
                while (idx <= i) and matches == n:    
                    if (i-idx) < len(result):
                        result = s[idx:i+1]
                        flag = True

                    out_char = s[idx]
                    if out_char in hmap:
                        hmap[out_char] += 1
                    if hmap[out_char] == 1:
                        matches -= 1
                    if start < len(indices) - 1:
                        start = start + 1 
                        idx = indices[start]
                    else:
                        break

        return result if flag else ""


