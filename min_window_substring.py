# Time Complexity : Add - O(2n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Store target tring in hashmap with size of each charachter
2. Apply window with left being fixed and right being mobile, put the charachter to a dffernt hashmap, if all target string charachter are in the window, record minmum window, and left and right

3. Now squeeze window, to get min possible window
'''

from collections import Counter, defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if not s or len(s) < 1 or len(t) < 1:
            return ""
        
        target_hash = Counter(t)
        window_hash = defaultdict(lambda : 0)
        form = 0
        
        left = 0
        right = 0
        
        min_ = len(s)
        
        result = [-1]*3
        # print (target_hash)
        while (right < len(s)):
            
            window_hash[s[right]] += 1
            
            if window_hash[s[right]] == target_hash[s[right]]:
                form += 1
            
            while left<=right and form == len(target_hash):
                # print ("here")
                
                if (result[0] == -1 or right - left + 1 < result[0]):
                    
                    result[0] = right - left + 1
                    result[1] = left
                    result[2] = right
                
                window_hash[s[left]] -= 1
            
                if target_hash[s[left]] > 0 and window_hash[s[left]] < target_hash[s[left]]:
                    form -= 1
                    
                left += 1
            
            
            right += 1
            
        # print (result, left, right)
        
        if result[1] is not None and result[2] is not None:
            return s[result[1]:result[2]+1]
        else:
            return ""
                    
                    
            
                
