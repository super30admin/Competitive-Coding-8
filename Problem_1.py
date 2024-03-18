'''
Time Complexity - O(n). We are traversing each character of String S
Space Complexity - O(1). Even though we are using a hashmap its of constant size(26)

Works on Leetcode
'''


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m = len(s)
        n = len(t)
        if m == 0 or n == 0 or m<n: #return empty string pattern length is more than Source string length
            return ""
        
        hashMap = {} # char -> count
        for c in t: #Insert all the characters of pattern in the hashMap
            hashMap[c] = hashMap.get(c, 0)+1
        
        i, j =0, 0 #start pointer and end pointer
        temp = 1e5+1 #length of the string between the start and end pointer
        result = ""
        matchC = 0
        while i<=j and i<len(s):
            if (i<j and matchC == len(hashMap)) or j == len(s): #if we had a match or end pointer is at end of source string
                '''
                Here we move the start pointer (i). so we are taking out a character.
                if that character is present in the map, we need to increment count.
                if this count goes above 0 it means that the updated string does not contain updated character
                '''
                if s[i] in hashMap:
                    cnt = hashMap.get(s[i]) + 1
                    hashMap[s[i]] = cnt
                    if cnt == 1:
                        matchC -=1                    
                i+=1
            else:
                '''
                Here we move the end pointer as we do not have sufficient strings that satisfy the pattern
                If the current character is present in the hashMap then we reduce the count. if the character count reaches 0, it means the substring satisfies the count for the character
                Therefore increment match
                '''
                if s[j] in hashMap:
                    cnt = hashMap.get(s[j]) - 1
                    hashMap[s[j]] = cnt
                    if cnt == 0:
                        matchC+=1
                j+=1
            '''
            If number of matching characters is same as size of hashMap, it means we have a qualifying substring, we find its length and check if its smaller than
            current min and replace the substring accordingly
            '''
            
            if matchC == len(hashMap):
                temp = min(temp, j-i)
                if temp == j-i:
                    result = s[i:j]
        return result
                


        