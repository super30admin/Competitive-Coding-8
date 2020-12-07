#Time Complexity : O(s+t) where s and t are the lengths of the input string
#Space Complexity : O(t) where t is the length of the target string
#Did this code successfully run on Leetcode : Yes


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        tCounts = collections.Counter(t) #get counts of all chars in target string
        n = len(t)
        minLen = float("inf")
        result = []

        start= 0
        #iterate through s sting
        for end in range(len(s)):
            if tCounts[s[end]] > 0: #if count of curr pointer char in the target string is still greater than 0 then decrement missing characters
                n -= 1
            tCounts[s[end]] -= 1 #reduce count of curr pointer char in target string
            #till our missing elements remain 0 run a while loop
            while n == 0:
                currLen = end-start+1 #get current window size
                if currLen < minLen: #if current window size is less than existing window length update result and min window size
                    minLen = currLen
                    result = [start, end]
                tCounts[s[start]] += 1 #increment count start pointer char in t as we are removing that from our window
                if tCounts[s[start]] > 0:
                    n += 1

                start += 1

        if result:
            return s[result[0]:result[1]+1]
        return ""
