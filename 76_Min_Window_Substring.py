# Leetcode problem link : https://leetcode.com/problems/minimum-window-substring/
# Time Complexity:    O(m+n) 
# Space Complexity:   O(m+n)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
      1. Maintain a map fo string to be found.
      2. Two pointer approach to traverse the bigger string to find the smaller one.
      3. Keep updating the hashmap for bigger string as and when end pointer expands towards right. If the count of character at end pointer is also present in hashmap of smaller string and frequency is same or lesser then formed can be incremented by 1.
      4. Keep expanding towards right till the time formed is less than required. As soon as it becomes equal, try to decrease the window from left side and updating the minDist and minStart and end values as well.
''' 
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        minStart = 0
        minEnd = 0
        minDist = float('inf')
        sMap = {}
        tMap = {}
        for c in t:
            if c in tMap:
                tMap[c] += 1
            else:
                tMap[c] = 1
        
        start = 0
        end = 0
        formed = 0
        required = len(t)
        while end < len(s):
            # keep expanding towards right to get all characters from t in s
            while end < len(s) and formed < required:
                currEnd = s[end]
                # update current right character in smap
                if currEnd in sMap:
                    sMap[currEnd] += 1
                else:
                    sMap[currEnd] = 1
                # check if it is also present in tmap and satisfies the criteria of all characters
                
                if currEnd in tMap and sMap[currEnd] <= tMap[currEnd]:
                    formed += 1
                
                end += 1
            
            # keep decreasing window size once criteria is satisifed
            
            while start < len(s) and formed == required:
                currDist = end - start + 1
                if currDist < minDist:
                    minDist = currDist
                    minStart = start
                    minEnd = end
                currStart = s[start]
                if currStart in sMap:
                    sMap[currStart] -= 1
                
                if currStart in tMap and sMap[currStart] < tMap[currStart]:
                    formed -= 1
                
                start += 1
        
        if minStart <= minEnd:
            return s[minStart:minEnd]
        else:
            return ''
                