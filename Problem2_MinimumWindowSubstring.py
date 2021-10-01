# Time Complexity: O(m + n), where m - length of s and n - length of t
# Space Complexity: O(n), where n - length of t

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        # Dict to store count of all unique chars of t
        tmap = Counter(t)

        required = len(tmap)  # Number of chars that need to be present in the window
        formed = 0  # To keep track of formed chars of t with its frequency
        l = r = 0  # left and right pointers

        # Variables to store the size, left and right indices of the minimum window
        min_window = -1
        left = right = 0

        while r < len(s):
            # Add one right char to the window
            ch = s[r]
            if ch in tmap:
                tmap[ch] -= 1
                # If desired char frequency is reached, increment formed
                if tmap[ch] == 0:
                    formed += 1

            # Try to reduce the window size while maintaining the required char frequencies
            while l <= r and formed == required:
                ch = s[l]

                # Save the smallest window until now
                curr_window = r - l + 1
                if min_window == -1 or curr_window < min_window:
                    min_window = curr_window
                    left = l
                    right = r

                # Remove the left char from the window
                if ch in tmap:
                    tmap[ch] += 1
                    # If a desired char is removed, decrement formed
                    if tmap[ch] > 0:
                        formed -= 1

                l += 1

            r += 1

        return "" if min_window == -1 else s[left: right + 1]
