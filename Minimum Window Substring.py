# Time Complexity : O(n)
# Space complexity : O(1) for the hash map which will have a maximum size of 26.

# Maintaining a hash map with keys equal to the characters in the t string. Maintain two pointers, i and j to mark the start and end indices of a substring that matches t. Whenever a match is found, we try to move the start pointer such that the new sub string still has all the elements. Update the result whenever a smaller substring is found.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == '':
            return t
        d = {}; n = len(s)
        for key in t:
            if key in d:
                d[key] += 1
            else:
                d[key] = 1

        match = len(d.keys())
        size = n + 1; res = ''
        i = 0
        for j in range(n):
            
            c = s[j]
            if c in d:
                d[c] -= 1
                if d[c] == 0:
                    match -= 1
            # print(d, match)
            while match == 0:
                if (j - i + 1) < size:
                    res = s[i:j+1]
                    size = j - i + 1

                if s[i] in d:
                    d[s[i]] += 1
                    if d[s[i]] > 0:
                        match += 1
                i += 1
        return res