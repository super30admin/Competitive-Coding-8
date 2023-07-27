#Space complexity: O(N) where N is the length of s
#Time complexity: O(M) where M is the length of t
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        #Base case
        if(len(s)==0 or len(t)==0 or len(s)<len(t)):
            return ""
        #Initializing all the requried variables
        hm={}
        match=0
        temp=float('inf')
        
        output=""
        #We will be going through all the characters in t
        #and we will be creating a hashmap
        for i in t:
            if(i not in hm):
                hm[i]=0
            hm[i]+=1
        length=len(hm)
        i=0
        j=0
        #We will be iterasting through s untl the below condition fails 
        while(i<=j and i<len(s)):
            #If match count is equal to the length of the hashmap, we will
            #chech the length of the string 
            if(match==length):
                temp=min(temp,j-i)
                #If the minimum value is equal to the j-i, we ewill update the output string
                if(temp==j-i):
                    output=s[i:j]
            #If the match is equal to the length of the s or j reaches the end
            if((i!=j and match==len(hm)) or j==len(s)):
                #If s[i] is present in hm
                if(s[i] in hm):
                    #We will increase the count fo that key in hashmap
                    hm[s[i]]+=1
                    #And if the count is greater than 0, we will decrease the match value
                    if(hm[s[i]]>0):
                        match-=1
                #We will increase i value 
                i+=1
            #If the match value is less than the length of the hashmap
            else:
                #WE will check if s[j] is present in hashmap
                if(s[j] in hm):
                    #If present, we will reduce the count by 1
                    hm[s[j]]-=1
                    #If the value of the key is equal to 0, we will increase the match value by 1
                    if(hm[s[j]]==0):
                       match+=1
                #We will be moving j to next position
                j+=1
        #Finally we are returning the output string
        return output
                