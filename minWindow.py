# TimeComplexity:O(m+n)
# SpaceComplexity:O(1) 26/52 letters
# Approach: Use two pointer plus sliding window approach maintain have and need counts. lets say at some point have ==need we try to move left pointer until have =need we have have samller ans 
# insider l to r.if using sliding window with 2 pointer instrings always rememebr to have ''have and ned variables
# https://leetcode.com/problems/minimum-window-substring/
# s = "ab" * 5000 + "c"
# t = "abc" this is worst case
# need is the number of unique characters in t.
# have tracks how many of those characters have matched frequency between s[l:r+1] and t.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        sub_hashmap,t_hashmap=defaultdict(int),defaultdict(int)
        for i in t:
            if i in t:
                t_hashmap[i]+=1
            else:
                t_hashmap[i]=1
        have,need=0,len(t_hashmap)
        
        l=0
        res_l,res=float('inf'),[-1,-1] #instead of updating ans each time we are tracking idx
        for r in range(len(s)):
            ch=s[r]
            if ch in t_hashmap:sub_hashmap[ch]+=1
            if ch in t_hashmap and t_hashmap[ch]==sub_hashmap[ch]:
                have+=1
            if have==need:
                # res_l=r-l+1
                # res=[l,r]
                while(have==need and l<len(s)):
                    if res_l>r-l+1:
                        res_l=r-l+1
                        res=[l,r]
                    if l<len(s) and s[l] in sub_hashmap:
                        sub_hashmap[s[l]]-=1
                        if sub_hashmap[s[l]]<t_hashmap[s[l]]:
                            have-=1
                    l+=1
        res=s[res[0]:res[1]+1]
        return res
