# Time Complexity: O(n + m) where n is the length of s and m is the length of t
# Space Complexity: O(m) for the dictionary to store character counts of t
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        # Step 1: Count frequency of each character in t
        dict_t = Counter(t)
        required = len(dict_t)

        # Step 2: Initialize pointers and helpers
        l, r = 0, 0
        formed = 0
        window_counts = defaultdict(int)
        ans = float('inf'), None, None  # window length, left, right

        # Step 3: Expand the right pointer
        while r < len(s):
            character = s[r]
            window_counts[character] += 1

            # Check if current char meets the requirement
            if character in dict_t and window_counts[character] == dict_t[character]:
                formed += 1

            # Step 4: Contract the left pointer when window is valid
            while l <= r and formed == required:
                if r - l + 1 < ans[0]:
                    ans = (r - l + 1, l, r)

                # Remove the leftmost character from the window
                window_counts[s[l]] -= 1
                if s[l] in dict_t and window_counts[s[l]] < dict_t[s[l]]:
                    formed -= 1

                l += 1  # shrink the window

            r += 1  # expand the window

        # Step 5: Return the smallest valid window
        return "" if ans[0] == float('inf') else s[ans[1]:ans[2]+1]
