class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l = 0
        n = len(s)
        
        tCount = collections.Counter(t)
        sCount = collections.defaultdict(int)
        uniqueT = len(tCount)
        matched = 0
        minL, minR = -1, -1
        minLen = n + 1

        for r in range(n):
            sCount[s[r]] += 1
            if s[r] in tCount and sCount[s[r]] == tCount[s[r]]:
                matched += 1

            while matched == uniqueT:
                if (r - l + 1) < minLen:
                    minLen = r - l + 1
                    minL, minR = l, r
                if s[l] in tCount and sCount[s[l]] == tCount[s[l]]:
                    matched -= 1
                sCount[s[l]] -= 1
                l += 1

        if minL != -1:
            return s[minL: minR + 1]
        return ""