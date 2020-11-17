# Time Complexity: O(∣S∣+∣T∣) where |S| and |T| represent the lengths of strings S and T. In the worst case we might end up visiting every element of string S twice, once by left pointer and once by right pointer. |T| represents the length of string T.

# Space Complexity: O(∣S∣+∣T∣). ∣S∣ when the window size is equal to the entire string S. ∣T∣ when T has all unique characters.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        dict_t = {}
        for i,ch in enumerate(t):
            if ch in dict_t:
                dict_t[ch] += 1
            else:
                dict_t[ch] = 1
                
        required = len(dict_t)
        dict_s = {}
        l = 0
        Min = float("inf")
        ans = ""
        formed = 0
        
        for r,ch in enumerate(s):
            dict_s[ch] = dict_s.get(ch,0) + 1
            
            if ch in dict_t and dict_s[ch]==dict_t[ch]:
                formed += 1
                
            while formed==required:
                char = s[l]
                if Min>r-l+1:
                    ans = s[l:r+1]
                    Min  = r-l+1 
                dict_s[char] -= 1
                if char in dict_t and dict_s[char]<dict_t[char]:
                    formed -= 1
                l+=1
        return ans
            