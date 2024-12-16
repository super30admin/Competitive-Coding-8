# Approach:
# We use the sliding window technique with two pointers: left and right.
# We move the right pointer to expand the window and include characters from t.
# Once the window contains all characters from t, we try to shrink the window by moving the left pointer.
# We track the minimum window length that contains all characters from t and return it.
# If no such window exists, we return an empty string.

# Time Complexity : O(m + n)
# Space Complexity : O(m + n) where m is the length of string s and n is the length of string t.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, it was straightforward once the sliding window approach was clear.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # Step 1: Edge case where t is longer than s
        if len(s) < len(t):
            return ""

        # Step 2: Initialize counters for characters in t and the current window in s
        t_count = Counter(t)  # Counter for characters in t
        window_count = Counter()  # Counter for characters in current window
        left, right = 0, 0  # Sliding window pointers
        min_len = float('inf')  # Minimum length of valid window found so far
        min_window = ""  # Result to store the minimum window substring

        # Step 3: Expand the right pointer and slide the window
        while right < len(s):
            # Include current character in the window and expand the right pointer
            window_count[s[right]] += 1
            right += 1
            
            # Step 4: Once we have a valid window (all characters of t are in the window)
            while self.is_valid_window(window_count, t_count):
                # Update the result if we found a smaller valid window
                if right - left < min_len:
                    min_len = right - left
                    min_window = s[left:right]
                
                # Try to shrink the window from the left side
                window_count[s[left]] -= 1
                if window_count[s[left]] == 0:
                    del window_count[s[left]]  # Remove the character if its count becomes zero
                left += 1  # Move left pointer to shrink the window

        # Step 5: Return the minimum window found, or an empty string if no valid window
        return min_window

    # Helper function to check if the current window contains all characters of t
    def is_valid_window(self, window_count, t_count):
        for char in t_count:
            if window_count[char] < t_count[char]:
                return False
        return True
