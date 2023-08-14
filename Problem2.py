#Time Complexity :- O(m)
#Space COmplexity :- O(n) where n is the length of smaller string which is T

class Solution:
    def minWindow(self, s: str, t: str) -> str:

        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return ''

        hashMap = {}
        for i in range(len(t)):
            if t[i] not in hashMap:
                hashMap[t[i]] = 0
            hashMap[t[i]] += 1
        i, j = 0, 0
        outputString = ''
        match = 0
        temp = math.inf

        while i<=j and i < len(s):
            if match == len(hashMap):
                temp = min(temp, j- i)
                if temp == j - i:
                    outputString = s[i:j]
                
            if match == len(hashMap) and i<=j or j>=len(s):
                if s[i] in hashMap:
                    if hashMap[s[i]] == 0:
                        match -= 1
                    hashMap[s[i]] +=1    
                i+=1
            else:
                if s[j] in hashMap:
                    if hashMap[s[j]] ==1:
                        match+=1
                    hashMap[s[j]] -=1
                j+=1
        return outputString


