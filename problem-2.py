
# 76. Minimum Window Substring

# Code:


class Solution:
    def minWindow(self, string: str, pattern: str) -> str:
        # Base case:
        if len(pattern)>len(string):
            return ""
        
        # Initalizing variables and datastructures:
        mapping = collections.Counter(pattern)
        
        start = 0
        end = 0
        count = 0
        validation = len(pattern)
        res = [0, 0, len(string)+1]
        final_start = start
        
        # Loop through the given string once: O(N)
        
        for end in range(len(string)):
            char = string[end]
            if char in mapping:
                mapping[char]-=1
                if mapping[char]>=0:
                    count+=1
              
            # Keep shrinking the window(increment start) until it's valid.
            # valid: all the chars in pattern should be present in the window.
            while validation == count:
                window_size = end-start+1
                if window_size<res[2]:
                    res = [start, end, window_size]
                    # (final_start) Need a copy of start here.
                    # Since this is the place we are updating the windowsize.
                    final_start = start

                shrink = string[start]
                start+=1
                if shrink in mapping:
                    if mapping[shrink]==0:
                        count-=1
                    mapping[shrink]+=1
        
        return string[final_start:final_start+res[2]] if res[2]<=len(string) else ""


# Time Complexity: O(N)
# Space Complexity : O(1)
# Accepted on Leetcode: Yes