# TC : O(n^2)
# SC : O(1) - map of 26 characters

class Solution(object):
    def longestSubstring(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: int
        """

        return self.helper(s,0,len(s),k)


    def helper(self,str, start, end, k):
        if end < k:
            return 0
        char_map = {}

        for i in range(start, end):
            if str[i] not in char_map:
                char_map[str[i]] = 0
            char_map[str[i]] += 1


        for split in range(start, end):
            if char_map[str[split]] < k:
                split_next = split + 1
                while split_next < end and char_map[str[split_next]] < k:
                    split_next = split_next + 1
                print(split_next)
                return max(self.helper(str, start, split, k), self.helper(str, split_next,end,k))
        return end - start