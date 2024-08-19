class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        Time Complexity: O(N ) where N is the length of s
        Space Complexity: O(1)
        """

        t_map = {}  # To store the frequency of each character in `t`
        window = {}  # To store the frequency of each character in the current window of `s`

        # Populate `t_map` with the frequency of characters in `t`
        for i in range(len(t)):
            if t[i] not in t_map:
                t_map[t[i]] = 0
                window[t[i]] = 0  # Initialize `window` dictionary with the same keys as `t_map`
            t_map[t[i]] += 1

        need = len(t_map)  # Number of unique characters in `t` that must be in the window
        have = 0  # Number of unique characters in the current window that match the frequency in `t_map`
        l = 0  # Left pointer for the sliding window
        resLen = float('inf')  # To store the length of the smallest window found
        res = [-1, -1]  # To store the start and end indices of the smallest window

        # Iterate over the string `s` with the right pointer `r`
        for r in range(len(s)):
            char = s[r]
            if char in t_map:
                window[char] += 1  # Increment the count of the current character in the window
                if window[char] == t_map[char]:  # If the current character's count matches that in `t_map`
                    have += 1  # Increment the `have` counter
            
            # When all characters in `t` are covered in the current window, try to shrink the window
            while have == need:
                # Update the result if the current window is smaller than previously found windows
                if r - l + 1 < resLen:
                    resLen = r - l + 1
                    res[0] = l
                    res[1] = r

                # Try to remove the leftmost character from the window
                if s[l] in t_map:
                    window[s[l]] -= 1
                    if window[s[l]] < t_map[s[l]]:
                        have -= 1  # If removing the character makes the window invalid, decrement `have`
                l += 1  # Move the left pointer to the right

        l = res[0]
        r = res[1]

        # Return the smallest window if found, otherwise return an empty string
        if resLen != float('inf'):
            return s[l:r + 1]
        else:
            return ""
