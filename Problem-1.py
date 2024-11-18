#Approach
#maintain a reach and frequency dict idf the reach eqaul to the len(t) check previous string length and update
#when it reach id equal the in creament the pointer of i untill the reach is not equal to len(t)

#Complexities
#Time: O(n)
#Space: O(1)


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s)<len(t):
            return ""
        hashMap = dict()
        reach = 0
        result = ""
        result_length = float("inf")
        for char in t:
            hashMap[char] = hashMap.get(char,0)+1

        memoMap = hashMap.copy()

        i= 0

        for j in range(len(s)):
            if s[j] in hashMap:
                hashMap[s[j]] = hashMap.get(s[j],0)-1
                if hashMap[s[j]]==0:
                    reach+=memoMap[s[j]]

            while reach == len(t):
                if (j-i+1) < result_length:
                    result_length = j-i+1
                    result = s[i:j+1]
                if s[i] in hashMap:
                    if hashMap[s[i]]==0:
                        reach -=memoMap[s[i]]

                    hashMap[s[i]]+=1
                i+=1
        return result