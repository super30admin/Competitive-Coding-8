# Time Complexity: O(m+n) m,n are lenghths of S and T
# Space Complexity: O(1) here both dictionaries can have maximum size of 26 unique charachters
# Approach: We use 2 pointers left and right and use sliding window approach. We keep moving right until the condition where all the char with corr freq in T are found in the window in S. Once we get this window, we start moving or left pointer to validate if the satisfaction still holds for the frequecies to gte the smallest substring. We keep moving left until the happens and store the length the indices of this substring. Once that condition is no longer met, we start moving our right pointer to find other windows with the substring and do the same approach as before.
# Did it run on Leetcode:Yes

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l, r = 0, 0
        charfreqrequired = Counter(t)  # Dictionary to store the char and corr freq in T that are required
        charfreqinwindow = {}  # Dictionary that contains char and corr freq of char in our current window
        chartomatch = len(charfreqrequired)  # No of unique char that are required
        charmatched = 0  # No of char in window that satisfy the freq condition
        ans = float("inf"), None, None
        while r < len(s):
            char = s[r]  # start moving from right
            charfreqinwindow[char] = charfreqinwindow.get(char, 0) + 1  # inc freq of char in window dictionary
            if char in charfreqrequired and charfreqrequired[char] == charfreqinwindow[char]:  # if freq is satisfied
                charmatched += 1  # No of char satisfying condition incremented
            while l <= r and charmatched == chartomatch:  # if the desired window is found
                char = s[l]  # start moving from left
                if r - l + 1 < ans[0]:  # Len of this window is less that current min window size
                    ans = (r - l + 1, l, r)  # new window size
                charfreqinwindow[char] -= 1  # this this char will be removed from the window
                if char in charfreqrequired and charfreqinwindow[char] < charfreqrequired[
                    char]:  # if this char was the one satisfying the condition
                    charmatched -= 1
                l += 1  # keep moving left until desired window condition is met
            r += 1  # Move right as soon as condition is not met
        return "" if ans[0] == float("inf") else s[ans[1]:ans[2] + 1]
