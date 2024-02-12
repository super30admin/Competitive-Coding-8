class Solution:
    def minWindow(self, s: str, t: str) -> str:
        d = dict()
        for i in t:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i] += 1
        match = len(d)
        i = 0
        minSize = len(s)+1
        result = ''
        for j in range(len(s)):
            c = s[j]
            if c in d.keys():
                d[c] -= 1
                if d[c] == 0:
                    match -= 1
            while match == 0:
                temp = j - i + 1
                if temp < minSize:
                    minSize = temp
                    result = s[i:j+1]
                
                if s[i] in d.keys():
                    d[s[i]] += 1
                    if d[s[i]] > 0:
                        match += 1
                i += 1
        return result
# Time complexity O(n), n is the length of 's'
# Space complexity O(1)