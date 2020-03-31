# Time Complexity : O(N)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : No

#I am trying to debug the solution. Some minor flaw while coding.Trying to figure out.


# Your code here along with comments explaining your approach


from collections import defaultdict
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(s) < len(t):
            return ""
        tmap = defaultdict(int)
        mainmap = defaultdict(int)
        for i in range(len(t)):
            tmap[t[i]] += 1
            
        start = 0
        end = 0
        
        result = [float('inf'),0,0]
        formed = 0
        
        while end < len(s):
            
            mainmap[s[end]] +=1
            if s[end] in tmap and tmap[s[end]] == mainmap[s[end]]:
                formed += 1
            while formed == len(t) and start<=end:
                if end-start+1 < result[0]:
                    result[0] = end-start+1
                    result[1] = start
                    result[2] = end
                    
                mainmap[s[start]] -=1
                if s[start] in tmap and tmap[s[start]] > mainmap[s[start]]:
                    formed -=1
                start +=1
             
            end +=1
        if result[0] == float('inf'):
            return ""
        else:
            return (s[result[1]:result[2]+1])            
                    
                    
                    
            