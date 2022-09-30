class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s is None or len(s) == 0:
            return ""

        m = {}
        wordmap = {}
        for i in range(len(t)):
            char = t[i]
            m[char] = m.get(char, 0) + 1
        # print(m)
        i = 0  # left pointer
        j = 0  # right pointer
        required = len(t)
        arr = [-1, 0, 0]
        formed = 0

        while j < len(s):
            c = s[j]
            wordmap[c] = wordmap.get(c, 0) + 1
            # print(wordmap)
            if c in m and m.get(c) >= wordmap.get(c):
                formed += 1
            # print(formed, required)
            while formed == required and i <= j:
                # print(j-i,i,j)
                if arr[0] == -1 or arr[0] > (j - i):
                    arr[0] = j - i + 1
                    arr[1] = i
                    arr[2] = j
                c = s[i]
                # i += 1
                wordmap[c] = wordmap.get(c) - 1
                if c in m and wordmap.get(c) < m.get(c):
                    formed -= 1
                i += 1
            j += 1
        # print(arr)
        if arr[0] == -1:
            return ""
        else:
            return s[arr[1]:arr[2] + 1]

# two pointers
# Time Complexity : O(m + n)
# Space Complexity : O(m + n) size of the hashmap for letter of string s and size of the frequency map
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
