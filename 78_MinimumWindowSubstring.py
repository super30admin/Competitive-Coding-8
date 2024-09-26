# Time Complexity: O(n), n = len(s)


# Hashmap, Sliding window and two pointers
# make hashmap for String t
# take two pointers od String s
# first pointer will be on first char and second char will move to the String S
# take match variable to count the charcters which will match with string t
# if match == len(hashmap of t), then we set the temporary resulting  string between two pointer 
# afetr than we increase the first pointer and incresing the second pointer from first to len(s).....
# if we find match == len(hashmap), then we update the temporary string with min length, and in the return this string
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        hashMap = {}
        slow = 0
        fast = 0
        match = 0
        minLen = inf
        minStr = ""
        
        for i in t:
            if i not in hashMap:
                hashMap[i] = 0
            hashMap[i] +=1
        
        while (slow <= fast and slow < len(s)) :
            if match == len(hashMap):
                minLen = min(minLen,fast-slow)
                if minLen == (fast-slow):
                    minStr = s[slow:fast]
             
            if (slow != fast and match == len(hashMap)) or (fast == len(s)):
                if s[slow] in hashMap:
                    if hashMap[s[slow]] == 0:
                        match -=1
                    hashMap[s[slow]] +=1
                slow += 1
            else:
                if s[fast] in hashMap:
                    if hashMap[s[fast]] ==1:
                        match +=1
                    
                    hashMap[s[fast]] -=1
                fast+=1
        return minStr
                
            
        