# problem 1 

# https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # iterate the map 
        map_data = {}
        min_length = float('inf')
        for ch in t:
            if ch in map_data:
                map_data[ch]+=1
            else:
                map_data[ch] = 1
        counter = len(t)
        start_ptr = 0
        last_start_ptr = 0
        for i in range(len(s)):
            ch = s[i]
            if ch in map_data:
                # count only if they are gt than 0
                if map_data[ch] > 0:
                    counter-=1
                map_data[ch]-=1
            while counter == 0:# we found all elements
                if i - start_ptr + 1 < min_length:
                    min_length = i - start_ptr +1
                    last_start_ptr = start_ptr
                if s[start_ptr] in map_data:
                    map_data[s[start_ptr]]+=1
                    if map_data[s[start_ptr]] > 0:
                        counter+=1
                start_ptr+=1
        if (min_length) == float('inf'):
            return ""
        starting_ptr = last_start_ptr
        end_ptr = last_start_ptr+min_length
        return s[starting_ptr:end_ptr]
