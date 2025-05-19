class Solution:
    def minWindow(self, s: str, t: str) -> str:
        """
        Approach:
        1. Use the sliding window technique with two pointers (l and r) to find the smallest substring in `s`
           that contains all characters of `t`.
        2. Use two hashmaps:
           - `target`: counts of each character in `t`
           - `window`: current counts of characters in the window
        3. Expand the right pointer `r` to include characters in the window until all required characters are met.
        4. Then shrink from the left (`l`) to find the minimal valid window.
        5. Keep track of the minimum length and starting/ending indices of the valid windows.

        Time Complexity: O(s + t) — Each character in `s` and `t` is visited at most a few times.
        Space Complexity: O(t) — For storing character counts of `t` and the current window.
        """
        if len(t) > len(s) or t == "":
            return ""
        
        window = {}
        target = {}

        for n in t:
            target[n] = 1 + target.get(n, 0)
        
        have, need = 0, len(target)
        l = 0
        result = [-1, -1]
        resLen = float('inf')

        for r in range(len(s)):
            char = s[r]
            if char in target:
                window[char] = 1 + window.get(char, 0)
                if window[char] == target[char]:
                    have += 1
            
            while have == need:
                if (r - l + 1) < resLen:
                    resLen = (r - l + 1)
                    result = [l, r]
                if s[l] in target:
                    window[s[l]] -= 1
                    if window[s[l]] < target[s[l]]:
                        have -= 1
                l += 1
            
        l, r = result
        return s[l:r + 1] if resLen != float('inf') else ""
