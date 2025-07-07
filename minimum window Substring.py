#Time Complexity: O(M + N)
#Building Frequency map O(M) 
#Space Complexity: O(M)
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        p1,p2 = 0,0
        #Create a frquency map
        freq_map = {}
        for char_ in t:
            if char_ not in freq_map: 
                freq_map[char_] = 1
            else:
                freq_map[char_] += 1
        
        len_t = len(t)
        res = ""
        midle_string = ""
        current_min = float('inf')
        ##iterate over s
        while p2 < len(s):
            if s[p2] in freq_map:
                if freq_map[s[p2]] > 0:
                    len_t -= 1
                freq_map[s[p2]] -= 1
            p2 += 1
            while len_t == 0:
                substring_len = p2-p1
                current_min = min(current_min,substring_len)
                if current_min == substring_len:
                    res = s[p1:p2]
            
                if s[p1] in freq_map:
                    freq_map[s[p1]] += 1
                    if freq_map[s[p1]] > 0:
                        len_t += 1   
                p1 += 1
                
        return res




        



        