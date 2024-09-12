"""
Time Complexity : O(S + T) where S & T are lenghts of strings S and T respectively
Space Complexity : O(S + T) where S & T are lenghts of strings S and T respectively
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) == 0 or len(t) == 0:
            return ""
        t_dict = {}
        for i in t:
            if i in t_dict:
                t_dict[i] += 1
            else:
                t_dict[i] = 1
        s_dict = {}
        numChars = len(t_dict)
        result = float('inf'), None, None
        foundSubstr = 0
        left = 0
        right = 0
        while right < len(s):
            c = s[right]
            s_dict[c] = s_dict.get(c, 0) + 1
            
            if c in t_dict and s_dict[c] == t_dict[c]:
                foundSubstr += 1
            while left <= right and foundSubstr == numChars:
                c = s[left]
                if right - left + 1 < result[0]:
                    result = (right - left + 1, left, right)
                    
                s_dict[c] -= 1
                if c in t_dict and s_dict[c] < t_dict[c]:
                    foundSubstr -= 1
                    
                left += 1
            right += 1
        if result[0] == float('inf'):
            return ""
        else:
            return s[result[1] : result[2] + 1]