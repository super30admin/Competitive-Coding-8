#Time Complexity = O(n)
#Space Complexity = O(1)
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""
        tFreq = {}
        for char in t:
            tFreq[char] = tFreq.get(char,0)+1

        wFreq = {}
        left = 0
        minLength = float("inf")
        formed = 0
        start = 0
        for right in range(len(s)):
            char = s[right]
            wFreq[char] = wFreq.get(char,0) +1

            if char in tFreq and wFreq[char] == tFreq[char]:
                formed += 1

            while left <= right and formed == len(tFreq):
                if right - left +1 < minLength:
                    minLength = right-left +1
                    start = left
                leftChar = s[left]
                wFreq[leftChar] -= 1
                if leftChar in tFreq and wFreq[leftChar]< tFreq[leftChar]:
                    formed -= 1
                left += 1
        return "" if minLength == float("inf") else s[start:start+minLength]
