# Time Complexity: O(m)
# Space Complexity: O(n)
class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        m = len(s)
        n = len(t)
        
        dictS = {e: t.count(e) for e in set(t)}
        print(dictS)
        
        i, j = 0, 0
        ans = ""
        while i < m and j < m:
            if s[j] in dictS:
                dictS[s[j]] -= 1

            while all(v <= 0 for v in dictS.values()) and i<=j:
                if ans == "":
                    ans = s[i:j+1]
                else:
                    ans = ans if len(ans) < len(s[i:j+1]) else s[i:j+1]
                if s[i] in dictS:
                    dictS[s[i]] += 1
                i+=1
            j+=1

        return ans