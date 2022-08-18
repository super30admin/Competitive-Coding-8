#Time Complexity => O(N)
#Space Complexity => O(1)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t=="" or s=="":
            return ""
        window = dict()
        target = dict()
        # Inserting target values for count in hashmap
        for i in t:
            if(target.get(i) is None):
                target[i] = 0
            target[i]+=1
        cnt = 0
        req = len(target)
        #To store result start and end indexes
        result = [-1, -1]
        res_len = 2**32
        i=0
        for j in range(len(s)):
            #Adding letters to the window until we find the target substring
            x = s[j]
            if(window.get(x) is None):
                window[x]=0
            window[x]+=1
            if x in target and window[x]==target[x]:
                cnt+=1
            #Once required substring is obtained we update the window by removing the first letter in the window
            while cnt==req:
                # Update the result if we get a minimized substring
                if(j-i+1)<res_len:
                    result = [i,j]
                    res_len = j-i+1
                window[s[i]]-=1
                if s[i] in target and window[s[i]] < target[s[i]]:
                    cnt-=1
                i+=1
        l,r = result
        if(res_len!=2**32):
            return s[l:r+1]
        else:
            return ""