# Time Complexity : O(m+n)
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        res_s = {}
        res_t = {}
        count = 0
        start = 0
        j = 0
        front = -1
        mn = float('inf')
        for i in t:
            if i not in res_t:
                res_t[i] = 1
            else:
                res_t[i] += 1
        
        
        for j in range(len(s)):
            if s[j] not in res_s:
                res_s[s[j]] = 1
            else:
                res_s[s[j]] += 1
        
            if res_s[s[j]] > 0 and s[j] in res_t and res_s[s[j]] <= res_t[s[j]]:
                count += 1
            
            if count == len(t):
                while s[start] not in res_t or res_t[s[start]] < res_s[s[start]]:
                    if s[start] in res_t and res_t[s[start]] < res_s[s[start]]:
                        res_s[s[start]] -= 1
                    start += 1
                ln = j - start + 1
                if mn > ln:
                    mn = ln
                    front = start
    
        return "" if front is -1 else s[front:front+mn]
