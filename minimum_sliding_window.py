# Time Complexity : O(2*m); m --> len(s)
# Space Complexity : O(n); n --> len(t)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

from collections import Counter


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        check = Counter(t)
        start = 0
        end = 0
        result = [float('inf'), start, end]
        n = len(t)
        m = len(s)
        matched = 0
        while end < m:
            if matched != len(check):
                if s[end] in check:
                    check[s[end]] -= 1
                    if check[s[end]] == 0:
                        matched += 1
            while start <= (end - n + 1) and matched == len(check):
                if result[0] > (end-start+1):
                    result = [(end-start+1), start, end]
                if s[start] in check:
                    check[s[start]] += 1
                    if check[s[start]] == 1:
                        matched -= 1
                start += 1
            end += 1
        return '' if result[0] == float('inf') else s[result[1]:result[2]+1]


print(Solution().minWindow("ADOBECODEBANC", "ABC"))


# TC: O(n^2)
# class Solution:
#     def minWindow(self, s: str, t: str) -> str:
#         result = [float('inf'), 0, 0]
#         n = len(t)
#         m = len(s)
#         for i in range(m):
#             matched = 0
#             check = Counter(t)
#             for j in range(i, m):
#                 if s[j] in check:
#                     check[s[j]] -= 1
#                     if check[s[j]] == 0:
#                         matched += 1
#                 if matched == len(check):
#                     if j - i + 1 < result[0]:
#                         result = [(j-i+1), i, j]
#                     continue
#         return '' if result[0] == float('inf') else s[result[1]:result[2]+1]
#
#
# print(Solution().minWindow("ADOBECODEBANC", "ABC"))
