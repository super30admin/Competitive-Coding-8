class Solution:
    
    """
    Description: Min window substring
    
    Time Complexity: O(s + t)
    Space Complexity: O(s + t)
    
    "Not a working solution, still on-going"
    
    Approach: 2 pointers
    1. create 2 hash tables, one for t and one for ongoing substring
    2. move right index until all the characters in the string t are met for a substring defined by left and right index 
    3. move left index until the characters match and the size of substring is lower than previously found substring
    4. loop until the right pointer goes out of bounds
    """
    
    def minWindow(self, s: str, t: str) -> str:
        
        minSubstr = ""; flag = False
        if s == None or t == None: return minSubstr
        
        from collections import defaultdict
        t_dict = defaultdict(int)
        win_dict = defaultdict(int)
        for char in t:
            t_dict[char] += 1
            
        # use 2 pointers
        left = 0; right = 0
        substr_len = 0
        
        while right < len(s):
            char = s[right]
            win_dict[char] += 1
            size = len(win_dict)

            if char in t_dict:
                while win_dict[char] == t_dict[char]:
                    left += 1
                    substr_len = right - left + 1
                    char = s[left]
                    win_dict[char] -= 1
                
            right += 1
            
        return s[left:right]
