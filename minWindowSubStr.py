class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # T: O(n + m), T: O(m)
        if not s or not t:
            return ""

        t_count = Counter(t)
        required = len(
            t_count
        )  # Number of unique characters in t that need to be in the window

        left, right = 0, 0
        formed = (
            0  # Counts how many unique characters in t are fully matched in the window
        )
        window_counts = {}

        min_length = float("inf")
        min_window = (0, 0)

        while right < len(s):
            char = s[right]
            window_counts[char] = window_counts.get(char, 0) + 1

            if char in t_count and window_counts[char] == t_count[char]:
                formed += 1  # This unique character is fully satisfied

            while left <= right and formed == required:
                # Update minimum window
                if (right - left + 1) < min_length:
                    min_length = right - left + 1
                    min_window = (left, right)

                # Try to remove from left
                left_char = s[left]
                window_counts[left_char] -= 1
                if (
                    left_char in t_count
                    and window_counts[left_char] < t_count[left_char]
                ):
                    formed -= 1  # We lost a fully matched character

                left += 1

            right += 1

        l, r = min_window
        return s[l : r + 1] if min_length != float("inf") else ""
