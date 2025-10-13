# Time Complexity : O(N) where N is the length of the string s
# Space Complexity : O(1) as 26 letters in the alphabet
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am two hashmap to keep track of the characters in t and the characters in the current window of s.
# I am using two pointers to keep track of the current window in s.
# I am expanding the window by moving the right pointer and adding the character to the smap.
# If the character is in tmap and the count of the character in smap is equal to the count in tmap, I am incrementing the have variable.
# If the have variable is equal to the length of tmap, I am contracting the window by moving the left pointer and removing the character from the smap.
# If the character is in tmap and the count of the character in smap is less than the count in tmap, I am decrementing the have variable.
# I am keeping track of the minimum length of the window and the starting index of the window.
# At the end, I am returning the substring of s from the starting index to the starting index + minimum length.

from collections import Counter, defaultdict
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        tmap = Counter(t)
        left = 0
        miny = float('inf')
        smap = defaultdict(int)
        have = 0
        result = 0
        for i in range(len(s)):
            smap[s[i]] += 1
            if s[i] in tmap and smap[s[i]] == tmap[s[i]]:
                have += 1
            while have == len(tmap):
                if i - left + 1 < miny:
                    miny = i - left + 1
                    result = left
                smap[s[left]] -= 1
                if s[left] in tmap and smap[s[left]] < tmap[s[left]]:
                    have -= 1 
                left += 1
        return s[result:result+miny] if miny != float('inf') else ""
                


        