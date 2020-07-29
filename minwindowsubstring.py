# SOLUTION 1
# by maintaining hash tables
# time complexity - O(s+t) 
# space complexity - O(t) -- s for counts and s for indices
# Did this code run on leetcode? - yes
# Did you encounter any issues? - this solution only works when the pattern does not have repeated characters.
from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # keep the count of characters of the pattern string.
        counts_t = Counter(t)
        # keep the length of the unique characters.
        match = len(counts_t)
        
        # store the indices of characters.
        indices = {}
        
        # variable to keep the track of minimum length and indices.
        minlen = float('inf')
        minidx = (-1, -1) 
        
        # keep the track of beginning of the matched characters
        for i, ch in enumerate(s):
            if ch in counts_t:
                temp = indices[ch] if ch in indices else -1
                indices[ch] = i
                counts_t[ch] -= 1
                if counts_t[ch] == 0:
                    match -= 1
                
                # find the minimum index i.e. the starting point in the hash table
                # and find the length of the sequence
                if match==0 and (minidx[0]==-1 or minidx[0] == temp):
                    start_idx = min(indices.items(), key=lambda kv: kv[1])[1]
                    
                    if minlen > (i-start_idx+1):
                        minlen = i-start_idx+1
                        minidx = (start_idx, i)
                
        return "" if minlen==float('inf') else s[minidx[0]:minidx[1]+1]

    
# SOLUTION 2
# STEPS:
# 1. Count the characters in the pattern string and store them in a hashmap for easy access
# 2. Keep a match variable to store if the substring till a point matches the pattern string.
# 3. Move the right (r) pointer till the first matched substring is found.
# 4. If the match becomes 0, start moving the left (l) pointer to find the location of the beginning of the substring match.
# 5. Compare the lengths of the substrings and track the minimum length substring location.
# 6. Returns an empty string if no substring is matched.
# Time complexity - O(t+s)
# Space complexity - O(t)
# Did this code run on leetcode? - yes
# Did you encounter any issues? - had to refer to the leetcode solution.

from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # keep variables to store the length of the min length subtring, minidx and maxidx.
        minlen = float('inf')
        minidx = (-1, -1)
        
        # keep the counts of characters in T
        counts_ch = Counter(t)
        match = len(counts_ch)
        
        # traverse the string s
        l, r = 0, 0
        n = len(s)
        
        # traverse the right pointer till it reaches the end of the string.
        while r < n:
            ch = s[r]
            if ch in counts_ch:
                counts_ch[ch] -= 1         # decrement the counts if the character is present in the dictionary.
                if counts_ch[ch] == 0:     # reduce the match if all the instances of that character have been found.
                    match -= 1
            
            # move the left pointer to find the new start of the string
            while match == 0 and l<=r:
                ch = s[l]
                if ch in counts_ch:
                    if counts_ch[ch] == 0: # if the outgoing character can distrupt the found pattern, increment the count
                        match += 1
                    counts_ch[ch] += 1      
                
                # compare the substring lengths
                if minlen > (r-l+1):
                    minlen = (r-l+1)
                    minidx = (l, r)
                
                l+=1                      # increment the left pointer.
                
            r+=1                          # increment the right pointer.
        
        return "" if minlen == float('inf') else s[minidx[0]: minidx[1]+1]
    
    

# SOLUTION 3    
# Improve the solution by filtering out the locations from t that matches with the character in s.
# time complexity - O(t+s) -- slightly better when the pattern is small in length
# space complexity - O(t)
from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # keep variables to store the length of the min length subtring, minidx and maxidx.
        minlen = float('inf')
        minidx = (-1, -1)
        
        # keep the counts of characters in T
        counts_ch = Counter(t)
        match = len(counts_ch)
        
        # filter the location of s characters
        filtered_ch = []
        for i, ch in enumerate(s):
            if ch in counts_ch:
                filtered_ch.append((i, ch))
        
        # traverse the string s
        l, r = 0, 0
        n = len(s)
        
        # traverse the right pointer till it reaches the end of the string.
        while r < len(filtered_ch):
            ch = filtered_ch[r][1]
            if ch in counts_ch:
                counts_ch[ch] -= 1         # decrement the counts if the character is present in the dictionary.
                if counts_ch[ch] == 0:     # reduce the match if all the instances of that character have been found.
                    match -= 1
            
            # move the left pointer to find the new start of the string
            while match == 0 and l<=r:
                ch = filtered_ch[l][1]
                if ch in counts_ch:
                    if counts_ch[ch] == 0: # if the outgoing character can distrupt the found pattern, increment the count
                        match += 1
                    counts_ch[ch] += 1      
                
                # compare the substring length
                start = filtered_ch[l][0]
                end = filtered_ch[r][0]
                
                if minlen > (end-start+1):
                    minlen = (end-start+1)
                    minidx = (start, end)
                
                l+=1                      # increment the left pointer.
                
            r+=1                          # increment the right pointer.
        
        return "" if minlen == float('inf') else s[minidx[0]: minidx[1]+1]
        