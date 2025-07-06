"""
I solved the problem using the sliding window technique with two hash maps: one for storing the character frequency of string t, and another for tracking the current window in s. As I expanded the right pointer, I updated the window frequency. Once all required characters matched, I tried shrinking the window from the left to find the smallest valid substring. At each valid window, I updated the result if it was smaller than the previous best.
Time Complexity: O(n), where n is the length of s.
Space Complexity: O(1), since the alphabet size is fixed (only upper/lowercase letters).
"""
from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(t) > len(s) or len(t) == 0 or len(s) == 0:
            return ""
        
        hashMapT = Counter(t)
        required = len(hashMapT)
        present = 0
        left = 0
        windowCounter = {}
        result = [-1,-1]
        sizeResult = float("inf")

        for right in range(len(s)):
            char = s[right]
            windowCounter[char] = windowCounter.get(char, 0) + 1

            if char in hashMapT and windowCounter[char] == hashMapT[char]:
                present += 1
            
            while present == required:

                #calculate the result
                windowSize = right - left + 1
                if windowSize < sizeResult:
                    result = [left, right]
                    sizeResult = windowSize
                
                #remove from left
                leftChar = s[left]
                windowCounter[leftChar] -= 1
                if leftChar in hashMapT and windowCounter[leftChar] < hashMapT[leftChar]:
                    present -= 1

                left += 1
                
        return s[result[0]:result[1] + 1]