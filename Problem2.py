# Time Complexity : O(mxn) 
# Space Complexity :O(mxn) ,for dp matrix.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        map_ = Counter(t)
        start = 0 
        end = 0 
        result = ''
        target_len = len(t) 
        
        for i in range(len(s)):
            if map_[s[i]] > 0:
                target_len -= 1 
            
            map_[s[i]] -= 1 
            
            while (target_len == 0): 
                window_len = i - start + 1 
                
                if not result or window_len < len(result):
                    result = s[start : i + 1]
                
                map_[s[start]] += 1 
                
                if map_[s[start]] > 0: 
                    target_len += 1 
                
                start += 1 
        
        return result 