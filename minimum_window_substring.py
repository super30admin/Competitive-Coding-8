# Time Complexity: O(n + m)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The code finds the minimum window that contains all the characters in t by using a hashmap to keep track of the 
characters in t and a sliding window to keep track of the characters in s. 
"""

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == None or t == None or len(s) == 0 or len(t) == 0 or len(s) < len(t): return ''

        answer = ''.join(['a' * (len(s) + 1)])
        useful_indices = []
        hashmap = collections.Counter(t)
        start_index = 0
        match = 0

        for index in range(len(s)):
            if s[index] in hashmap:
                useful_indices.append(index)
                hashmap[s[index]] -= 1
                if hashmap[s[index]] == 0: 
                    match += 1

                if match == len(hashmap):
                    if len(s[useful_indices[start_index]: index + 1]) < len(answer):
                        start = useful_indices[start_index]
                        answer = s[start: index + 1]
                    start_index += 1
                    to_remove = s[useful_indices[start_index - 1]]
                    hashmap[to_remove] += 1
                    if hashmap[to_remove] == 1:
                        match -= 1

            while match == len(hashmap):
                if len(s[useful_indices[start_index]: index + 1]) < len(answer):
                    start = useful_indices[start_index]
                    answer = s[start: index + 1]
                start_index += 1
                to_remove = s[useful_indices[start_index - 1]]
                hashmap[to_remove] += 1
                if hashmap[to_remove] == 1:
                    match -= 1

        return '' if answer == ''.join(['a' * (len(s) + 1)]) else answer