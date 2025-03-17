# Problem 1 : Minimum Window Substring
# Time Complexity : O(n) where n is the size of the string s
# Space Complexity : O(k) where k is the size of the string k
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # edge case if the length of the string s and t are 0 or length of the string s is less than the string t then return ""
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ""
        # define hash map to store the frequency of the character in string t
        hashMap = {}
        for i in range(len(t)):
            # if there is no entry of ith character in hash map then create an entry in the map and initialize the value to 0
            if t[i] not in hashMap:
                hashMap[t[i]] = 0
            # increment the frequency of the character in string t
            hashMap[t[i]] += 1
        # initialize the start and end pointer for string s
        i, j = 0, 0
        # initialize the tempLength which will store the minimum length of the match string till now
        tempLength = len(s) + 1
        # initialize the output string as empty which will store the minimum string
        outputString = ""
        # initialize the matchCount as 0 which will store the count of match 
        matchCount = 0
        # loop till the j is less than the length of the string s
        while j < len(s):
            # if the character at jth position is in hashmap
            if s[j] in hashMap:
                # if it is then decrement the count of frequency
                hashMap[s[j]] -= 1
                # if the frequency in hash map of the character is 0 then increment matchCount since we got match
                if hashMap[s[j]] == 0:
                    matchCount += 1
            
            # if the matchCount is equal to length of the hash map and i is less than j then we need to shrink the i pointer
            # since we need string of minimum length 
            while matchCount == len(hashMap) and i <= j:
                # first check if j-i+1 is less than the minimum length of the match string till now
                if j - i + 1 < tempLength:
                    # if it is then set the tempLength and output with the length and string
                    tempLength = j - i + 1
                    outputString = s[i:j+1]
                # check if the character at ith position is in hashmap
                if s[i] in hashMap:
                    # if it is then increment the frequency in hashmap
                    hashMap[s[i]] += 1
                    # if the frequency is equal to 1 ie we don't have exact of match of the character
                    if hashMap[s[i]] == 1:
                        # decrement the matchCount
                        matchCount -= 1
                # increment the ith pointer
                i += 1
            # increment the jth pointer
            j += 1
        # after traversing the string return the output string
        return outputString
                 