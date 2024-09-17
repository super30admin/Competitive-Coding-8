--------------------------find the window which contais all the characters ------------------------------------------
# Time Complexity : O(M+N) as M is length of s and N is the length of t
# Space Complexity : O(s+t) stack space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I used sliding window approach, where I got the frequency of the characters in t and iterating each and every char,
#in s and checking if that character is required char. If it is required and decrementing the count and char in dict and decrement the missing char count.
#When all the chars are found, we will check the start character and if it in and need , increment the count.
# and if the count is greater then 0, then we will increase the required count. We will check for the minimum count of the length of the string.



class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        
        need = Counter(t)
        start = 0
        end = 0
        missing = len(t)
        res = float('inf')
        out = ""
        while end<len(s):
            temp = s[end]
            
            if temp in need:
                if need[temp]>0:
                    missing -=1
                need[temp] -=1
            
            while missing<=0:
                start_char = s[start]
                if start_char in need:
                    need[start_char] +=1
                    if need[start_char]>0:
                        missing +=1
                    
            
                if end-start<res:
                    res = end-start+1
                    out = s[start:end+1]
                
                start +=1
            end+=1
        return out
    