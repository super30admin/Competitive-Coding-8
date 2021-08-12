from collections import defaultdict, Counter


# Time Complexity: O(s+t)
# Space Complexity: O(s+t)
class Solution:
    def minWindow(self, s, t):
        #         Base Case
        if not s or not t:
            return ""
        if s == t:
            return t

        # we will create dictionary with counter in t string
        dictionary = Counter(t)
        #         We will initialize left and right index
        l = r = 0
        #       initialize result and minimum window
        result = ""
        min_window = float('inf')
        #         Iterate over the string s and decrement the counter for current chracter
        #         in s string if after this also we still have counter left we will update the right pointer
        for i in range(len(s)):
            curr = s[i]
            dictionary[curr] -= 1

            if dictionary[curr] >= 0:
                r += 1
            #             for that each character we will iterate over the string t and we will check that
            #             if current pointer window is less than current minimum window then we will update
            #             the min window and update the result and at any case case we will update the dictionary
            # and if it is still greater than 0 then we will reduce the window and update the left pointer and we
            # will do this for every character in the string s
            while r == len(t):
                if i - l + 1 < min_window:
                    min_window = i - l + 1
                    result = s[l: i + 1]
                dictionary[s[l]] += 1

                if dictionary[s[l]] > 0:
                    r -= 1
                l += 1

        return result





