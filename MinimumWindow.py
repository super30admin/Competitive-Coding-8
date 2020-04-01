'''
Solution:
1.  Initially store the frequencies of all chars in pattern string in a HashMap, and then 
    start storing the frequencies of all chars in the sliding window in another HashMap, and
    start comparing HashMap at the time of each sliding window, take out the minimum.
2.  If a sliding window contains all strings in the pattern, try to minimize the 
    sliding window by moving left pointer forward.
3.  If a sliding window doesn't contains all strings in the pattern, try to maximize
    the sliding window by moving right pointer forward.

Time Complexity:    O(n) and Space Complexity:  O(n)
n is the length of the main string.

--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        #   initializations for mins
        minLeft = 0
        minRight = -1
        minDist = len(s) + 2
        
        #   initializations for left and right pointers
        left = 0
        right = 0
        
        n = len(s)
        m = len(t)
        
        #   initializations for HashMaps
        mapT = {}
        mapS = {}
        formed = 0
        
        #   fill the HashMap for pattern string
        for char in t:
            if char in mapT:
                mapT[char] += 1
            else:
                mapT[char] = 1
         
        #   iterate until the right pointer reaches out of bounds and all 
        #   chars are not formed yet.    
        while (right < n):
            
            #   if all chars of pattern aren't present, move right pointer
            while (right < n and formed < m):

                #   update HashMap of main string
                currRight = s[right]
                if currRight in mapS:
                    mapS[currRight] += 1
                else:
                    mapS[currRight] = 1
                
                #   if char is in pattern HashMap and if frequency occurred till now is lesser
                #   to expected frequency => increment the length of formed count so far
                if currRight in mapT and mapS[currRight] <= mapT[currRight]:
                    formed += 1
                
                #  update right pointer 
                right += 1
            
            #   if all chars of pattern are present, move left pointer
            while (left < n and formed == m):

                #   check min distance and update all mins accordingly
                currDist = right - left + 1
                if currDist < minDist:
                    minLeft = left
                    minRight = right - 1
                    minDist = currDist
                
                #   update HashMap of main string
                currLeft = s[left]
                if currLeft in mapS:
                    mapS[currLeft] -= 1
                
                #   if char is in pattern HashMap and if frequency occurred till now is lesser
                #   to expected frequency => decrement the length of formed count so far
                if currLeft in mapT and mapS[currLeft] < mapT[currLeft]:
                    formed -= 1
                
                #   update the left pointer
                left += 1
         
        #   return the length of min sliding window           
        if (minRight >= minLeft):
            return s[minLeft : minRight+1]
        else:
            return ''
                