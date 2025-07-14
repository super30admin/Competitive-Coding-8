"""
Approach:
- Use a sliding window technique to find the minimum substring in 's' that contains all characters of 't'.
- Maintain a frequency map (t_map) of characters in 't'.
- Expand the right end of the window using pointer 'j'.
- For every character in 's[j]', if it exists in t_map, reduce its count.
- When all required characters are matched (tracked by 'current'), try to shrink the window from the left (using 'i') to find a smaller valid window.
- Track and update the minimum window using res and res_idx.

Time Complexity: O(s + t)
    - s: length of the string 's'
    - t: length of the string 't'
Space Complexity: O(t)
    - To store frequency map of 't'
"""

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_map = Counter(t)
        i = 0
        current = 0
        res = float('inf')
        res_idx = [-1, -1]
        for j in range(len(s)):
            if s[j] in t_map:
                t_map[s[j]] -= 1
                if t_map[s[j]] == 0:
                    current += 1
            while i <= j and len(t_map) == current:
                if j-i+1 < res:
                    res = j - i + 1
                    res_idx = [i,j]
                if s[i] in t_map:
                    t_map[s[i]] += 1
                    if t_map[s[i]] == 1:
                        current -= 1
                i += 1
        return s[res_idx[0]:res_idx[1]+1]

def main():
    sol = Solution()
    test_cases = [
        ("ADOBECODEBANC", "ABC", "BANC"),
        ("a", "a", "a"),
        ("a", "aa", ""),
        ("ab", "b", "b"),
        ("ab", "a", "a"),
        ("abc", "cba", "abc")
    ]
    
    for s, t, expected in test_cases:
        result = sol.minWindow(s, t)
        print(f"s: '{s}', t: '{t}' => Output: '{result}' | Expected: '{expected}' | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()
