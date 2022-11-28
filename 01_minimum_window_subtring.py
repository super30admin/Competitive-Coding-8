# https://leetcode.com/problems/minimum-window-substring/submissions/
#TC: O(len(s)) 
#SC: O(len(t)) #for creation of 2 hashMaps

"""
Solved Using: Sliding Window with variable window size

Approach:
- eg:  s = "ADOBECODEBANC", t = "ABC"

We create 2 hashMaps one for string S and one for string T. Both these hashmap contain same keys, ie unique char from string t. hashMapS has all keys but their values is set to 0.

As pointer p2 encounters char in string S which are present in hashMapT then we increment the count in hashMapS and if this count is less than or equal to the count in HashMapT then we increment the countS

while countS==countT:
    we continue reducing the window size by decrementing the pointer by increaing the pointer p1 and adding to our tempStr which is the result to be returned

lastly we again increment the pointer p2 so that we can find a new window

"""
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""
        
        countT = len(t)
        countS = 0
        
        hashMapS = collections.defaultdict(int)
        hashMapT = collections.defaultdict(int)
        
        for ch in t:
            hashMapT[ch] += 1
            hashMapS[ch] = 0
    
        p1, p2 = 0,0
        tempStr = ""
        while p2<len(s):
            c = s[p2]
            if  c in hashMapT:
                hashMapS[c] += 1
                if hashMapS[c] <= hashMapT[c]:
                    countS += 1
                    
                    
            while countS == countT:
                if tempStr == "":
                    tempStr = s[p1:p2+1]
                else:
                    if len(tempStr) > len(s[p1:p2+1]):
                        tempStr = s[p1:p2+1]
                ch = s[p1]
                if ch in hashMapS:
                    hashMapS[ch] -= 1
                    if hashMapS[ch] < hashMapT[ch]:
                        countS -= 1
                p1 += 1
            p2 += 1
        return tempStr