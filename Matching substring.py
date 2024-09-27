class Solution:
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """

        if not t or not s:
            return ""

        hashmap = {}
        slow = 0
        fast = 0
        charMatch = 0
        count = {}
        result = float("inf"), None, None

        for i in range(len(t)):
            ch = t[i]
            if ch in hashmap:
                hashmap[ch] += 1
            hashmap[ch] = 1

        for fast in range(len(s)):

            char = s[fast]
            if char in count:
                count[char] += 1
            count[char] = 1

            if char in hashmap and count[char] == hashmap[char]:
                charMatch += 1

            while slow <= fast and charMatch == len(hashmap):
                ch = s[slow]

                if fast - slow + 1 < result[0]:
                    result = (fast - slow + 1, slow, fast)

                count[ch] -= 1
                if ch in hashmap and count[ch] < hashmap[ch]:
                    charMatch -= 1

                slow += 1

            fast += 1
        return "" if result[0] == float("inf") else s[result[1]: result[2] + 1]
