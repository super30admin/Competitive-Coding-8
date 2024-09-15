class Solution:
    def minWindow(self, s: str, t: str) -> str:
        '''
        Time, Space Complexity: O(S+T)
        For time complexity, S + 2*S + T in worst case
        Missed edge cases for this question
        '''
        if(len(t)==1):
            if(t in s):
                return t
            else:
                return ""
        # z is hashmap of frequency of t
        z = {}
        for i in range(0,len(t)):
            if(t[i] in z.keys()):
                z[t[i]]+=1
            else:
                z[t[i]]=1
        # x is array of positions of char in s that are present in t
        x = []
        for i in range(0,len(s)):
            if(s[i] in z.keys()):
                x.append([s[i],i])
        
        # y is hashmap of characters that are visited with in the sliding window
        y = {}
        # i is right of sliding window
        i=0
        # j in left of sliding window
        j=0
        # r is used to check whether all the characters of t in sliding window are visited
        r=0
        min=float("inf")
        minStart=-1
        minEnd=-1
        # This loop is O(2*S) in worst case
        while(i<len(x)):
            c = x[i][0]
            if(c in y):
                y[c]+=1
            else:
                y[c]=1
            if(y[c]==z[c]):
                # if the frequency of character in sliding window is equal to t, increase r by 1
                r+=1
            # if r is equal to length of frequency map of t
            while(r==len(z) and j<=i):
                # we will try to find the minimum substring by removing unneccessary prefix
                # eg: s= "aaaaaaaaaaaabbbbbcdd", t="abcdd"
                # using procedure above loop we will get aaaaaaaaaaaabbbbbcdd
                # this loop is used to reduce to minimum valid substring
                # i.e. abbbbbcdd
                if(not y[x[j][0]]>=z[x[j][0]]):
                    break
                else:
                    if(x[i][1]-x[j][1]<min):
                        min = x[i][1]-x[j][1]
                        minStart = x[j][1]
                        minEnd = x[i][1]
                    if(y[x[j][0]]==z[x[j][0]]):
                        r-=1
                    y[x[j][0]]-=1
                j += 1
            i+=1
        if(minStart==-1):
            return ""
        else:
            return s[minStart:minEnd+1]       
