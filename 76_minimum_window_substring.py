from collections import Counter, defaultdict


class Solution:
    def minWindow(self, s, t):
        """
            Time Complexity - O(m+n)
            'n' is the length of string 's'
            'm' is the length of string 't'
            Space Complexity - O(1)
        """

        if not t or not s:
            return ""

        # Dictionary which keeps a count of all the unique characters in t.
        dict_t = Counter(t)

        # Number of unique characters in t, which need to be present in the desired window.
        required = len(dict_t)

        # left and right pointer
        left, right = 0, 0

        # formed is used to keep track of how many unique characters in t are present in the current window in its
        # desired frequency. e.g. if t is "AABC" then the window must have two A's, one B and one C. Thus formed
        # would be = 3 when all these conditions are met.
        formed = 0

        # Dictionary which keeps a count of all the unique characters in the current window.
        window_counts = defaultdict(int)

        # ans tuple of the form (window length, left, right)
        ans = float("inf"), None, None

        while right < len(s):

            # found contiguous match, cannot be shorter than this
            if ans[0] == len(t):
                break

            # Add one character from the right to the window
            character = s[right]
            if character in dict_t:
                window_counts[character] += 1
                # If the frequency of the current character added equals to the desired count in t then increment the
                # formed count by 1.
                if window_counts[character] == dict_t[character]:
                    formed += 1

            # Try and contract the window till the point where it ceases to be 'desirable'.
            while left <= right and formed == required:
                character = s[left]

                # Save the smallest window until now.
                if right - left + 1 < ans[0]:
                    ans = (right - left + 1, left, right)

                # The character at the position pointed by the `left` pointer is no longer a part of the window.
                if character in dict_t:
                    window_counts[character] -= 1
                    if window_counts[character] < dict_t[character]:
                        formed -= 1

                # Move the left pointer ahead, this would help to look for a new window.
                left += 1

                # Keep expanding the window once we are done contracting.
            right += 1
        return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]


if __name__ == '__main__':
    print(Solution().minWindow('ADOABECODEABANC', 'ABCA'))
