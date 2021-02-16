# T =O(m)
# S = O(1)

# Approach:
# We make a hashmap for the t string and traverse the s string and maintain another hask map overthere
# Whenever we encounter the char that are in t it is recorded by the frequency in the haskmpa for s.
# We then record the length of the substring. Now we need to move the traversal pointers of s so that we 
# dont take the once that are not needed again. That is done using the s hashmap that contains the frequency 
# an char that has the frequency more than 1 is the one that can be ignored and the next jump would be
# to a point where this additional char is not considered but still the other chars are considered.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tMap = {}
        sMap = {}
        
        for c in t:
            if c in tMap:
                tMap[c] += 1
            else:
                tMap[c] = 1
                
        low = 0
        high = 0
        formed = 0
        minLow , minHigh = 0, 0
        MinDist = float('inf')
        
        while high < len(s):
            while high < len(s) and formed < len(t):
                if s[high] in sMap:
                    sMap[s[high]] += 1
                else:
                    sMap[s[high]] = 1
                if s[high] in tMap and sMap[s[high]] <= tMap[s[high]]:
                    formed += 1
                high +=1
            
            while low < len(s) and formed == len(t):
                MoveBy = high - low + 1
                if MoveBy < MinDist:
                    MinDist,minLow,minHigh = MoveBy, low, high
                sMap[s[low]] -= 1
                if s[low] in tMap and sMap[s[low]] < tMap[s[low]]:
                    formed -= 1
                low += 1
             
        if minLow <= minHigh:
            return s[minLow:minHigh]
        return ""