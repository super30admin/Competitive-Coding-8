# Time O(2n)
# Space O(1)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        maxL = 0
        m = len(t)
        n = len(s)
        if n == m and s == t: return s
        tmap = defaultdict(int)
        for c in t:
            tmap[c] += 1
        
        slow = 0
        fast = 0
        result = [0,0]
        subLen = 0
        while slow < n - m or fast < n:
            if fast < n and s[fast] in tmap:
                #if maxL == 0: slow = fast
                tmap[s[fast]] -= 1
                if tmap[s[fast]] == 0:
                    maxL += 1
            while maxL == len(tmap): # because of duplicates we need to consider len(map)
                if subLen == 0 or (result[1] - result[0] + 1) > (fast - slow + 1):
                    result[0] = slow
                    result[1] = fast
                    subLen = fast - slow + 1
                
                if s[slow] in tmap: 
                    tmap[s[slow]] += 1
                    if tmap[s[slow]] == 1: maxL -= 1
                slow += 1

                while slow < n and s[slow] not in tmap:
                    slow += 1
                # if maxL == len(tmap):
                #     if subLen == 0 or (result[1] - result[0] + 1) > (fast - slow + 1):
                #         result[0] = slow
                #         result[1] = fast
                #         subLen = fast - slow + 1
            if fast < n: fast += 1 
            if fast == n and maxL < len(tmap): break
        return "" if subLen == 0 else s[result[0]: result[1]+1]
                        