# ----------------------------------------------------
# Intuition:
#
# We want the smallest substring of s that contains all characters of t,
# including duplicates.
#
# 1. Optimal Sliding Window:
#    - Use two pointers (left, right) to represent a sliding window.
#    - Expand right pointer to include characters until window contains all of t.
#    - Then move left pointer to shrink window as much as possible while keeping it valid.
#    - Track character frequencies to check if window is valid.
#    → Time: O(m + n), where m = len(s), n = len(t)
#    → Space: O(1), since charset is fixed uppercase/lowercase letters
#
# 2. Brute Force:
#    - Check every substring of s.
#    - For each substring, count characters and verify if it contains all of t.
#    - Track minimum length substring meeting criteria.
#    → Time: O(m^2 * n), very inefficient for large strings
#    → Space: O(1)
# ----------------------------------------------------

from typing import Dict
from collections import defaultdict


class Solution:
    # ----------------------------------------------------
    # Optimal Sliding Window Approach
    # ----------------------------------------------------
    def minWindow(self, s: str, t: str) -> str:
        n = len(s)
        t_freq = {}
        #Build frequency map for chars in t
        for char in t:
            t_freq[char] = t_freq.get(char, 0) + 1

        required = len(t_freq) #len of unique chars to be matched
        left = 0
        right = 0
        window_freq = {}  # Frequency map to count chars in the current window of s

        min_len = float("inf") 
        res = (0, 0) # for result indicies

        matched = 0 # count of unique chars meet the required freq

        # Explanding window by moving right pointer
        while right < n:
            char = s[right]
            window_freq[char] = window_freq.get(char, 0) + 1

            # If current char frequency matches the required count in t, increase matched count
            if char in t_freq and window_freq[char] == t_freq[char]:
                matched += 1

            # Contract window from the left as long as it remains valid (all chars matched)
            while left <= right and matched == required:
                if (right-left+1) < min_len:
                    min_len = right-left+1
                    res = (left, right)
                
                # Remove left char from window frequency as we try to shrink window
                window_freq[s[left]] -= 1
                # If removed char frequency falls below required count, decrease matched
                if s[left] in t_freq and  window_freq[s[left]] < t_freq[s[left]]:
                    matched -= 1
                # Move left pointer forward to try smaller window     
                left += 1

            # Move right pointer forward to expand window
            right += 1

        # Return the minimum window substring if found, else return empty string
        l, r = res
        if min_len != float("inf"):
            return s[l:r+1]
        else:
            return ""

    # ----------------------------------------------------
    # Brute Force Approach (Commented)
    # ----------------------------------------------------
    # def minWindow(self, s: str, t: str) -> str:
    #     from collections import Counter
    #     t_freq = Counter(t)
    #     n = len(s)
    #     min_len = float("inf")
    #     res = ""
    #     for i in range(n):
    #         window_freq = {}
    #         for j in range(i, n):
    #             window_freq[s[j]] = window_freq.get(s[j], 0) + 1
    #             if all(window_freq.get(c, 0) >= t_freq[c] for c in t_freq):
    #                 if (j - i + 1) < min_len:
    #                     min_len = j - i + 1
    #                     res = s[i:j+1]
    #                 break
    #     return res


# ----------------------------------------------------
# Example Usage:
# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()
    print(sol.minWindow("ADOBECODEBANC", "ABC"))  # Output: "BANC"
    print(sol.minWindow("a", "a"))                  # Output: "a"
    print(sol.minWindow("a", "aa"))                 # Output: ""
