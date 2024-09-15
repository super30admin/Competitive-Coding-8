# Approach - Since the question deals with window, we can use sliding window with left, right pointers.
# Right pointer expands the window and left contracts the window. Anytime the count in hashmap is zero, reduce the match by 1, since we found this character match

# Time - O(s + t) 
# Space - O(t)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if len(s) == 0 or len(t) == 0:
            return ""
        
        minWindow = float("inf")
        index = [-1,-1]
        
        left, right = 0, 0
        
        hashmap = Counter(t)
        matches = len(hashmap)h
        
        while right < len(s):
            
            char = s[right]
            
            if char in hashmap:
                hashmap[char] -= 1
                
                if hashmap[char] == 0:
                    matches -= 1
                    
            
            while matches == 0 and left <= right:
                
                char = s[left]
                
                if char in hashmap:
                    
                    if hashmap[char] == 0:
                        
                        matches += 1
                        
                    hashmap[char] += 1
                    
                
                if minWindow > right - left + 1:
                    minWindow = right - left + 1
                    
                    index = [left, right]
                    
                left += 1
                
            right += 1
            
        return "" if minWindow == float("inf") else s[index[0] : index[1] + 1]
                
                
            
        
        