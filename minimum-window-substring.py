'''
Time Complexity: O(n) as we traverse the string s once with two pointers
Space Complexity: O(n) as we are storing the frequency of characters in the target string
'''

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        windowDict = defaultdict(int)
        targetDict = {}

        # frequency map of target
        for char in t:
            if char not in targetDict:
                targetDict[char] = 1
            else:
                targetDict[char] += 1
        left = 0
        right = 0
        requiredCount = 0

        # optimal window size params
        minLength = float("inf")
        minLeft = 0
        minRight = 0

        while right < len(s):
            element = s[right]
            windowDict[element] += 1

            if element in targetDict and windowDict[element] == targetDict[element]:
                requiredCount += 1

            # decreasing the window to find optimal window
            while requiredCount == len(targetDict):
                windowDict[s[left]] -= 1
                # if the required count is decreased
                currLength = right - left + 1
                if currLength < minLength:
                    minLength = currLength
                    minLeft = left
                    minRight = right

                if s[left] in targetDict and windowDict[s[left]] < targetDict[s[left]]:
                    requiredCount -= 1
                left += 1

            right += 1

        if minLength != float("inf"):
            return s[minLeft : minRight + 1]

        return ""
