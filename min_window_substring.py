class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        #O(s+t)
        #O(t)
        start = 0
        minlen = float('+inf')
        pattern={}
        #dict of pattern frequency
        for i in t:
            pattern[i]=pattern.get(i,0)+1
        res = ""
        matched = 0
        #move in S
        for i in range(len(s)):
            #expanding window
            #right pointer will slide through
            endch=s[i]
            #if char found in pattern> decraese its need (count) and if need becomes zero >
            #mark matched as found one char with required frequency
            if endch in pattern:
                pattern[endch]-=1
                if pattern[endch]==0:
                    matched+=1
                    
            #when all chars found with required frequency
            while len(pattern)==matched:
                #mark as minlen and update res if less than global
                if i-start+1<minlen:
                    minlen=i-start+1
                    res=s[start:i+1]
                #window found>>now try to contact window from left side and check
                startch=s[start]
                start+=1
                #if outgoing char in pattern, increase its need 
                if startch in pattern:
                    pattern[startch]+=1
                    #if this makes frequency of outgoing char greater>mismatch>
                    #reduce match count
                    if pattern[startch]>0:
                        matched-=1
        return res
                    

        

            