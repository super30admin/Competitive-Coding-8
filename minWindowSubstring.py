# Time Complexity : O(M+N)
# Space Complexity : O(M+N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        lookUp = Counter(t)
        res = ""
        mx = float('inf')
        left = 0
        right = 0
        count = len(lookUp)
        
        while right < len(s):
            #right pointer
            while right < len(s) and count != 0:
                if s[right] in lookUp:
                    lookUp[s[right]] -= 1
                    
                    if lookUp[s[right]] == 0:
                            count -= 1
                right += 1
            #left pointer
            while left < right and count == 0:
                if right - left < mx:
                    mx = right - left
                    res = s[left:right]
                if s[left] in lookUp:
                    lookUp[s[left]] += 1
                    if lookUp[s[left]] > 0:
                        count += 1
                left += 1
        return res