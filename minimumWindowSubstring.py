
# // Time Complexity : O(s+t)
# // Space Complexity : O(s+t)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Put the letters and their frequency in a hashmap or initiate a counter. Start iterating over S and add two pointers(start and end) at the 0th index. Move end pointer ahead until the letters of S and their frequency equals that of hashmap of T. When it does, update the size of substring and pointers p1 and p2 to later return the substring if the size id minimum.
# Move the start pointer ahead by one index and start moving end pointer ahead until the same condition is fulfilled. Once the two hmaps match, move start pointer ahead till the point where the hashmaps remain the same. When the minimum window is acheived, update the size and pointers. At the end, return the substring.

from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:

        #creating hmap1 with keeping count of letters in t 
        hmap1= Counter(t)
        
        start,end = 0,0 
        charLen = 0
        
        hmap2 = {}
        
        #adding p1 and p2 as the pointers for final output string to get the substring
        winSize, p1, p2 = float('inf'), None, None
        
        while end<len(s):
            char = s[end]
            hmap2[char] = hmap2.get(char, 0) + 1
            
            
            if char in hmap1 and hmap2[char]==hmap1[char]:
                charLen += 1
            
            #comparing with hmap1, and then updating the window and pointers
            while start <= end and charLen == len(hmap1):
                char = s[start]
                
                #updating window size and window pointers
                if end-start+1 < winSize:
                    winSize= end-start+1
                    p1= start
                    p2=end
                
                hmap2[char]-=1
                
                if char in hmap1 and hmap2[char]<hmap1[char]:
                    charLen -= 1
                start+=1
            end += 1
            
        return "" if winSize == float('inf') else s[p1:(p2+1)]
                    
            
            
        