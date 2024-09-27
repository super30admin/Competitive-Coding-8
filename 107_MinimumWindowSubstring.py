# Accepted on leetcode(76)
# Time - O(S)
# Space - O(S+T)
# USing 2 pointers approach , move right pointer to search for each character of 't' in 's' and then move left pointer to decrese the final window size to return minimum size array.
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # edge case
        if len(s) == 0 or len(t) == 0:
            return ""
        dict_t = {}
        # create a HashMap for string 't' all letters and their number of occurances as values.
        for i in range(len(t)):
            if t[i] not in dict_t:
                dict_t[t[i]] = 1
            dict_t[t[i]] += 1

        # variables declaration
        required = len(dict_t)  # no. of characters present in 't'
        left = 0  # left pointer
        right = 0  # right pointer
        # if the formed length is same as required length, then the search string is found
        formed = 0
        # another HashMap for window size and elements in it.
        window = {}
        # to know the final length and indices of the found sunstring.
        ans = [-1, 0, 0]

        # iterate over string 's'
        while right < len(s):
            # Add characters to window HashMap
            c = s[right]
            if c not in window:
                window[c] = 1
            window[c] += 1

            # the character is in 't' string and count is same in both dict, increase formed.
            if c in dict_t and window[c] == dict_t[c]:
                formed += 1
            # this loop is to minimize the length of final substring
            while left <= right and formed == required:
                c = s[left]
                if ans[0] == -1 or right - left + 1 < ans[0]:
                    ans[0] = right - left + 1
                    ans[1] = left
                    ans[2] = right

                window[c] -= 1

                if c in dict_t and window[c] < dict_t[c]:
                    formed -= 1
                left += 1
            right += 1
        # print(ans)
        return s[ans[1]:ans[2] + 1] if ans[0] != -1 else ""