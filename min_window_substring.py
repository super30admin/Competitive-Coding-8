# Time complexity: O(m + n)
# Space complexity: O(m + n)

from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        
        t_count = Counter(t)
        required_chars = len(t_count)
        
        left = 0
        min_len = float('inf')
        min_window = ""
        formed_chars = 0
        
        window_counts = {}
        
        for right in range(len(s)):
            character = s[right]
            window_counts[character] = window_counts.get(character, 0) + 1
            
            if character in t_count and window_counts[character] == t_count[character]:
                formed_chars += 1
            
            while left <= right and formed_chars == required_chars:
                character = s[left]
                
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_window = s[left:right + 1]
                
                window_counts[character] -= 1
                if character in t_count and window_counts[character] < t_count[character]:
                    formed_chars -= 1
                
                left += 1
        
        return min_window
