"""
Sliding window approach
TC - O(∣S∣+∣T∣) where |S| and |T| represent the lengths of strings S and T.
SC - O(∣S∣+∣T∣). ∣S∣ when the window size is equal to the entire string S. ∣T∣ when T has all unique characters.
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s is None or len(s) == 0: return ""

        # dict for string t
        dict_t = Counter(t)
        required = len(dict_t)

        # use left and right pointers for sliding window
        l = 0
        r = 0

        # formed is used to keep track of how many unique characters in t are present in
        # current window in its desired frequency
        formed = 0

        # dict to keep track of all unique characters in current window
        window_counts = {}

        # ans tuple of the form (window length, leftm right)
        ans = float('inf'), None, None
        slen = len(s)

        while r < slen:
            # add one character fron the right to the window
            character = s[r]
            # increment count if found again
            window_counts[character] = window_counts.get(character, 0) + 1

            # if the frequency of the curr character added equaqls to teh desired count in t, then in t,
            # then increment formed count by 1
            if character in dict_t and window_counts[character] == dict_t[character]:
                formed += 1

            # try and contract window till the point where it ceases to be "desirable"
            while l <= r and formed == required:
                character = s[l]

                # save the smallest window
                if r - l + 1 < ans[0]:
                    ans = (r - l + 1, l, r)

                # the character at the position pointer by the left pointer is no longer a part of the window
                window_counts[character] -= 1
                if character in dict_t and window_counts[character] < dict_t[character]:
                    formed -= 1

                # move the left pointer ahead, this would help look for the new window
                l += 1

            # keep expanding the window once we are done contracting
            r += 1
        return "" if ans[0] == float('inf') else s[ans[1]: ans[2] + 1]
