# Time complexity - O(s+t) : length of s and t string resp.
# Space Complexity: O(s+t) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Store all the chars of t string with its frequency. Then traverse on s and maintain a window to record char with frequency in it. 


class Solution:
    def minWindow(self, s, t):
        if not t or not s:
            return ""
        
        required = dict()
        for c in t:
            required[c] = required.get(c, 0) + 1
        
        left, right = 0, 0
        formed = 0
        window_counts = {}
        p1, p2 = -1, -1
        min_len = float('inf')
        while right < len(s):
            window_counts[s[right]] = window_counts.get(s[right], 0) + 1
            if s[right] in required and window_counts[s[right]] == required[s[right]]:
                formed += 1
            while left <= right and formed == len(required):
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    p1 = left
                    p2 = right
                window_counts[s[left]] -= 1
                if s[left] in required and window_counts[s[left]] < required[s[left]]:
                    formed -= 1
                left += 1    
            
            right += 1
            
        return "" if min_len == float("inf") else s[p1:p2 + 1]