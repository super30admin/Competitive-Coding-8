class Solution:
    def minWindow(self, s: str, t: str) -> str:
        #Approach: Sliding Window with Hashmap
        #Time Complexity: O(len(s) + len(t))
        #Space Complexity: O(len(t))
        
        map = {}
        for char in t:
            map[char] = map.get(char, 0) + 1
            
        matched = 0
        minLen = float('inf')
        start = 0
        slow, fast = 0, 0
        while fast < len(s):
            char = s[fast]
            
            if char in map:
                map[char] -= 1
                
                if map[char] == 0:
                    matched += 1
                    
            while matched == len(map):
                char = s[slow]
                
                if char in map:
                    if map[char] == 0:
                        matched -= 1
                        if fast - slow + 1 < minLen:
                            minLen = fast - slow + 1
                            start = slow
                    
                    map[char] += 1
                    
                slow += 1
            
            fast += 1
                    
        if minLen > len(s):
            return ""
        else:
            return s[start : start + minLen]