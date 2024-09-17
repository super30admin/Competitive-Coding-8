from collections import Counter
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        if not s or not t:
            return ""
        
        counter = Counter(t)
        
        i , j , count = 0,0,len(counter)
        left , right , min_len = 0 , len(s)-1,  len(s)
        found = False
        
        while j < len(s):
            end_char = s[j]
            j+=1
           
            if end_char in counter:
               
                counter[end_char] -= 1
                
                if counter[end_char] == 0:
                    count -=1
                
            if count > 0: 
                continue
                   
            while count==0:
                start_char = s[i]
                i +=1
                                  
                if start_char in counter:
                    counter[start_char] += 1
                
                    if counter[start_char] > 0:
                        count +=1
            
            if j-i < min_len:
                left = i 
                right = j
                min_len = j-i 
                found = True        
        
        if found == False:
            return ""
        else:
            
            return s[left-1:right]
