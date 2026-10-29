# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using sliding window Approach. Initialize a HashMap and add frequencies of characters in t
# Initialize left pointer and counter to 0 and iterate over the string s using for loop
# Check if character in s is in HashMap and decrement its frequency. If the frequency is 0 then increment the counter by 1
# While the counter is equal to length of HashMap check if the substring formed from left:i+1 is less than the earlier substring using minlength set to float('inf)
# If it is replace the length and substring to minlength and smallest_sub string
# Increment the left pointer by 1 and move the window to remove one left character and add one character in the right
# For removing we increase frequency in HashMap if ch in HashMap and decrease the counter if the frequency of ch > 0
# Return smallest substring

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        chdict = {}
        for i in range(len(t)):
            if t[i] not in chdict:
                chdict[t[i]] = 1
            else:
                chdict[t[i]] += 1
        left = 0
        count = 0
        minlength = float('inf')
        smallest_sub = ""
        for i in range(len(s)):
            if s[i] in chdict:
                chdict[s[i]] -= 1
                if chdict[s[i]] == 0:
                    count += 1
            while count == len(chdict):
                if i - left + 1 < minlength:
                    smallest_sub = s[left:i+1]
                    minlength = i - left + 1
                if s[left] in chdict:
                    chdict[s[left]] += 1
                    if chdict[s[left]] > 0:
                        count -= 1
                left += 1
        return smallest_sub