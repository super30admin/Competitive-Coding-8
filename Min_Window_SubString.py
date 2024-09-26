class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        
        freq = Counter(t)
        counter = len(freq)
        start = 0
        end = 0
        result = ""
        length = float("inf")
        
         # making counter towards 0
        while end < len(s):
            ch = s[end]
            if ch in freq:
                freq[ch] -= 1
                if freq[ch] == 0:
                    counter -= 1
                    
            end += 1
            
            while counter == 0:
                if end - start < length:
                    result = s[start: end]
                    length = len(result)
                    
                ch = s[start]
                if ch in freq:
                    freq[ch] += 1
                    if freq[ch] == 1:
                        counter += 1
                        
                start += 1
                
        return result
