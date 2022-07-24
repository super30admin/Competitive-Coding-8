
# //Time : O(n)
# //Space : O(1)

class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """

class Solution:
    def minWindow(self, s,t):
        hmapt=dict()
        hmaps=dict()
        for i in range(len(t)):
            if t[i] not in hmapt.keys():
                hmapt[t[i]]=0
            hmapt[t[i]]+=1
        
        left=0
        right=0
        match=0
        hmaps=dict()
        length=100000+1
        lptr=0
        rptr=0
        while right<len(s):
            print(s[right])
            if s[right] not in hmaps.keys():
                hmaps[s[right]]=0
            hmaps[s[right]]+=1
            if s[right] in hmapt.keys() and hmapt[s[right]]==hmaps[s[right]]:
                match+=1
            while match==len(hmapt) and left<=right:
                if length==100000+1 or right-left+1<length:
                    length=right-left+1
                    lptr=left
                    rptr=right
                    
                if hmaps[s[left]]:
                    hmaps[s[left]]+=-1
                if s[left] in hmapt.keys() and hmaps[s[left]]<hmapt[s[left]]:
                    match-=1
                left+=1
            right+=1
        if length==100000+1:
            return ""
        else:
            return s[lptr:rptr+1]