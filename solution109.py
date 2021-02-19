#Time Complexity:O(n+m)
#Space Complexity:O(n)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s)==0 or len(t)==0:
            return ""
        dict={}                                         #decalre a hashmap that holds all characters in string t and its count
        for i in range(len(t)):                         #appending the hashmap with charachers and their counts of string t
            if t[i] not in dict:
                dict[t[i]]=0
            dict[t[i]]+=1
        dsize=len(dict)                                 #let dsize hold the length of dict
        left=0                                          #assign left and right pointer at the 0th position of string s
        right=0
        match=0
        ans=[-1,0,0]                                    #initialize the ans array that hold the size of the match , its start and end position in s string
        window={}                                       #declare a second hashmap that hold all characters within the sliding window and its count
        while right<len(s):                             #while the right pointer is within the string s
            ch=s[right]                                 #access character at position right
            if ch not in window:                        # if the character is not in window, add it to window
                window[ch]=0
            window[ch]+=1                               #increment the value of char count by one
            if ch in dict and dict[ch]==window[ch]:     #if the character is in the t string hash map and the count of character in both hasmaps are same increment match by one
                match+=1
            while left<=right and dsize==match:         #while left ius less than right and value of match is same as dsize
                ch=s[left]                              # access the character at the left position in string s
                if ans[0]==-1 or right-left+1<ans[0]:   # at 0th position of ans array if the value is -1 or the value is greater than the current diff between right and left pointer distance
                    ans[0]=right-left+1                 # update the length of current minimum string its start and end positions in s
                    ans[1]=left
                    ans[2]=right
                window[ch]-=1                           #decrement the value of char in sliding window(remove it from sliding window)
                if ch in dict and dict[ch]>window[ch]:  #on removal of char from sliding window decrement the match value and move left pointer by one
                    match-=1
                left+=1
            right+=1                                    #increment the right pointer to increase sliding window 
        if ans[0]==-1:                                  #if the minimum length is still -1 return empty string , else return the substring from s using the left and right pointer values
            return ""
        else:
            return s[ans[1]:ans[2]+1]