# Time Complexity : O(n)
# Space Complexity : O(t)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# using two pointers approach to check if the count of a particular character equals zero or not then if it equals zero then
# incrementing the match then playing with the pointers to accomodate the change and keeping track of the size of the window
# and saving the minimum size at every point
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        hashtable={}
        for x in t:
            if x not in hashtable:
                hashtable[x]=1
            else:
                hashtable[x]+=1
        count=len(t)
        start=0
        minSize=99999
        minStart=0
        for end in range(len(s)):
            if s[end] in hashtable:
                hashtable[s[end]]-=1
                if hashtable[s[end]]>=0:
                    count-=1
            if count==0:
                while True:
                    if s[start] in hashtable:
                        if hashtable[s[start]]<0:
                            hashtable[s[start]]+=1
                        else:
                            break
                    start+=1
                if minSize>end-start+1:
                    minSize=end-start+1; minStart=start
        if minSize==99999: 
            return ''
        else: 
            return s[minStart:minStart+minSize]
                
            