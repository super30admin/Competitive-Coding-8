# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using sliding window Approach. Initialize a HashMap and add frequencies of characters in t
# Initialize left and right pointers to 0 and iterate over the string s until right == length of s
# Initialize another HashMap with characters at right pointer and add the frequencies of it
# Check if character at right pointer is in first HashMap and if the frequcy is the same if it is then increment the counter by 1
# If the counter is equal to size of first HashMap and left <= right then check if the substring formed is less than the earlier substring
# If it is append the length and substring to res array
# Decrement the second HashMap character frequency by 1 as it gone out of current window
# If the character at left pointer is in first HashMap and the frequency of character at left pointer is less in second HashMap than the frequency in first HasHMap then decrement counter by 1
# Increment the left pointer by 1
# Increment the right pointer by 1
# Return smallest substring


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        dict = {}
        for i in range(len(t)):
            if t[i] in dict:
                dict[t[i]] += 1
            else:
                dict[t[i]] = 1
        res = [-1, ""]
        size = len(dict)
        windowdict = {}
        left = 0
        right = 0
        formed = 0
        while right < len(s):
            if s[right] in windowdict:
                windowdict[s[right]] += 1
            else:
                windowdict[s[right]] = 1
            if s[right] in dict:
                if dict[s[right]] == windowdict[s[right]]:
                    formed += 1
                while left <= right and formed == size:
                    if res[0] > right - left + 1 or res[0] == -1:
                        res[0] = right - left + 1
                        res[1] = s[left:right + 1]
                    windowdict[s[left]] -= 1
                    if s[left] in dict and windowdict[s[left]] < dict[s[left]]:
                        formed -= 1
                    left += 1
            right += 1

        return res[1]