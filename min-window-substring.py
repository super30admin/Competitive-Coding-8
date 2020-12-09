# Time Complexity: O(N)
# Space Complexity: O(N)
# Approach Use a sliding window to keep track of the occurances of a the pattern string in the main string. Shrink window when all characters are found.
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        start = 0
        min_length = float('+inf')
        pattern_map = collections.Counter(t)
        result = ""
        matched = 0

        for end in range(len(s)):
            end_char = s[end]
            if end_char in pattern_map:
                pattern_map[end_char] -= 1
                # If we have seen all occurances of character
                if pattern_map[end_char] == 0:
                    matched += 1

            # Pattern matched, let's shrink the window
            while len(pattern_map) == matched:
                # Update result
                if end - start + 1 < min_length:
                    min_length = end - start + 1
                    result = s[start:end+1]
                start_char = s[start]
                start += 1
                if start_char in pattern_map:
                    if pattern_map[start_char] == 0:
                        # This character was completely matched earlier
                        matched -= 1
                    pattern_map[start_char] += 1

        return result
