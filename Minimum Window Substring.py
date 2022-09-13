# TC : O(n)
#SC: O(1)

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s:
            return ""
        if len(t) > len(s):
            return ""
        
        h = {}
        
        for i in t:
            if i not in h.keys():
                h[i] = 0
            h[i] += 1
            
        rem = len(t) #Remaining no of elements from t we have to add to the substring
        
        left = 0
        right = 0 
        
        minlen = float('inf')
        min_left = -1
        min_right = -1
        
        while(right < len(s)):
            
            if rem > 0: # If there are more elements to add from t
                if s[right] in h.keys(): #Check is the current character is in keys of hash map
                    h[s[right]] -= 1
                    if h[s[right]] >=0: # If value at current char is 0 or more in the map
                        rem -= 1 # Then reduce rem by 1 which means we got one more character we need from t in the substring
                right += 1 # increment right to 1
            
            while rem == 0:
                # While rem is 0 it means that all required charcter i.e all chars in t are in the substring s[left:right+1]
                #So now we increase left value to reduce size of substring and see if we can get a smaller substring with rem == 0
                print(left,right)
                if (right-left) < minlen:
                    # If length of current substr is less than that of the minimum substr, update minimum substr to this one
                    minlen = right - left
                    min_left = left
                    min_right = right
                
                if s[left] in h.keys():
                    h[s[left]] += 1 # Increase value in hashmap at s[left] key by 1 as this char now goes out of our substring
                    if h[s[left]]>0:
                        rem += 1 # If the val at hashmap at s[left] is 1 or more it means we need one more element from t so we increase rem by 1
                left += 1
                
                
        
        if minlen == float('inf'):
            return "" # No possible susbtring that matches our requirements
#         ans = []
#         for i in range(min_left,min_right):
#             ans.append(s[i])
        
#         return "".join(ans)
        return s[min_left:min_right]
        