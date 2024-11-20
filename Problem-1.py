class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        hMap = {}

        if not s or not t:
            return ""

        for j in t:
            hMap[j] = hMap.get(j,0)+1

        left = 0
        right = 0
        min_len = float("inf")
        min_window = ""
        required = len(hMap)
        formed = 0
        new_map = {}
        

        for right in range(len(s)):
            char = s[right]
            new_map[char] = new_map.get(char,0) + 1
            if char in hMap and new_map[char] == hMap[char]:
                formed+=1

            while left <= right and formed == required:
                window_size = right - left + 1
                if(right-left+1 < min_len):
                    min_len = right-left+1
                    min_window = s[left:right+1]

                c = s[left]
                new_map[c] -= 1
                if c in hMap and new_map[c] < hMap[c]:
                    formed -= 1
                
                left+=1

            right += 1
        
        return min_window

        