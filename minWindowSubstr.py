class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # Approach: Use Sliding window
        # TC O(N)
        # SC O(1)
        
        # base case
        if len(t) > len(s): return ""
        
        # logic
        
        # declarations
        res = []
        res_len = float("Infinity")
        
        t_map = {}
        
        for c in t:
            t_map[c] = t_map.get(c, 0) + 1
        
        l = 0
        exp_match = len(t_map)
        match = 0

        for i in range(len(s)):
            c = s[i]
            if c in t_map:
                t_map[c] -= 1
                if t_map[c] == 0:
                    match += 1
            
            while match == exp_match:
                if res_len > (i - l + 1):
                    res = [l, i]
                    res_len = (i - l + 1)
                if s[l] in t_map:
                    t_map[s[l]] += 1
                    if t_map[s[l]] == 1:
                        match -= 1
                l += 1

        
        return s[res[0]:res[1]+1] if res_len != float("Infinity") else ""        