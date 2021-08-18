from collections import defaultdict
"""
Approach: using two hashmaps
1) start from left to right and add element to a window representing the substring
2) when all the required elements from 't' are in the window
    a) note the substring - this can be done by noteing down the indicies
    b) if the curr len in less than the previous len, update
3) now, it can be possible that after removing the left most char from the window, you substring still has all the required chars
    a) this would be a better result as the len of substring has decreased and we need to return the min len
    b) repeat this step as long as the required elements are not lost from the window


TC: O(n) | n-> len(s)
SC: O(n)
"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t: return ""
        need_dict = defaultdict(int) # required counter
        have_dict = defaultdict(int) # counter of current substring
        for char in t:
            need_dict[char] += 1
        start = 0 # left bound of the window
        matched_chars = 0 # num of chars that should match the count with t's hashmap
        min_len = float('inf') # global min
        position = [-1,-1] # start and end indicies of all possible substrings have t's chars
        
        for end in range(len(s)):
            in_char = s[end]
            have_dict[in_char] += 1 # include incoming char in window
            
            if in_char in need_dict and have_dict[in_char] == need_dict[in_char]:
                matched_chars += 1 # note how many chars from t match with window

            while matched_chars == len(need_dict): 
                # update result
                curr_len = end - start + 1
                if curr_len < min_len:
                    min_len = curr_len
                    position = [start, end]
                
                # remove left most element from result
                have_dict[s[start]] -= 1
                if s[start] in need_dict and have_dict[s[start]] < need_dict[s[start]]:
                    matched_chars -= 1 # if that element is from t
                start += 1
        
        if min_len == float('inf'): return ""
        return s[position[0]:position[1]+1]