""""// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        h = Counter(t)
        match = len(h)
        l = float('inf')
        result = []
        start = 0
        end = 0
        if len(s) < len(t):
            return ''
        if len(s) == len(t) == 1:
            if s != t:
                return ''

        while end < len(s):
            c = s[end]
            if c in h:
                h[c] -= 1
                if h[c] == 0:
                    match -= 1
            end += 1

            while match == 0:
                if end - start < l:
                    l = end - start
                    while len(result) != 0:
                        result.pop()
                    result.append(start)
                    result.append(end)

                k = s[start]
                if k in h:
                    h[k] += 1
                    if h[k] == 1:
                        match += 1
                start += 1
        print(result)

        if len(result) < 2:
            return ''

        return s[result[0]:result[1]]


# class Solution:
#     def minWindow(self, s: str, t: str) -> str:
#         h = Counter(t)
#         match = len(h)
#         l = float('inf')
#         result = ''
#         start = 0
#         end = 0
#
#         while end < len(s):
#             c = s[end]
#             if c in h:
#                 h[c] -= 1
#                 if h[c] == 0:
#                     match -= 1
#             end += 1
#
#             while match == 0:
#                 if end - start < l:
#                     l = end - start
#                     result = s[start:end]
#
#                 k = s[start]
#                 if k in h:
#                     h[k] += 1
#                     if h[k] == 1:
#                         match += 1
#                 start += 1
#         return result
