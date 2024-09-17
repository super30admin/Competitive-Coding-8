# TC: O(n)
# SC: O(n) 
from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # edge
        if not s or not t:
            return ""        
        # Data structures
        t_count = Counter(t)
        curr_window = {}
        
        t_req = len(t_count)
        t_cov = 0
        ans = None, None
        minPos = float("inf")
        
        # slide window
        left, right = 0, 0
        while right < len(s):
            # store curr char in curr window
            char = s[right]
            curr_window[char] = curr_window.get(char, 0) + 1
            
            # check curr char req is fullfilled
            if char in t_count and curr_window[char] == t_count[char]:
                t_cov += 1    
            # if desired substring, contract
            while left <= right and t_cov == t_req:
                # store curr desired if lesser
                if right - left + 1 < minPos:
                    minPos = right - left + 1
                    ans = left, right
                
                # remove left char from consideration
                char = s[left]
                curr_window[char] -= 1
                if curr_window[char] < t_count[char]:
                    t_cov -= 1
                
                # move left
                left += 1
            # move right
            right += 1
        return "" if minPos == float("inf") else s[ans[0]: ans[1]+1]