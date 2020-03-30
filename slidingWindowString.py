'''
Time Complexity: O(n + m) n -> length of s and m -> length of t
Space Complexity: O(t)
Did this code successfully run on Leetcode : Yes
Explanation: Create a sliding window to generate substrings containing elements of s. Keep a hashmap containing the
elements of s and their counts. Use 2 pointers start and end, We increase end to the right until we see all characters of t.
Once we see all characters of t we move start to the left and pop elements on the left until we reach a character in t.
We repeat above steps until end<len(s)
'''

import math

class Solution:

    def minWindow(self, s: str, t: str) -> str:
        if s == None or t == None:
            return ""

        frequency = {}

        for i in range(0, len(t)):
            ch = t[i]
            if ch in frequency:
                frequency[ch] += 1
            else:
                frequency[ch] = 1

        unique = len(frequency)

        start = 0
        end = 0
        temp = ''
        res = math.inf
        result = ''
        currentFrequency = {}

        current = 0

        while end < len(s):

            # print(end)
            ch = s[end]
            if ch in frequency:
                if ch in currentFrequency:
                    currentFrequency[ch] += 1
                else:
                    currentFrequency[ch] = 1

            if ch in frequency and frequency[ch] == currentFrequency[ch]:
                current += 1

            while start <= end and current == unique:

                if res > end - start + 1:
                    res = end - start + 1
                    result = s[start:end + 1]

                ch1 = s[start]
                if ch1 in frequency:
                    currentFrequency[ch1] -= 1

                if ch1 in frequency and frequency[ch1] > currentFrequency[
                    ch1]:
                    current -= 1

                start += 1
            end += 1

        if res == math.inf:
            return ''
        else:
            return result