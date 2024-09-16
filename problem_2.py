"""
Time Complexity : O(m+n)
Space Complexity : O(m+n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : no

This is a sliding window problem. We would maintain 2 hashmaps, one for s and one for t. Iterate through t and populate the hashmap.
We will keep a left and right pointer to iterate thorogh s. We need to keep moving right until we find a substring which has
all the chars of t with desired frequency. Once we reach that, we record the left and right positions and the distance and start
moving the left pointer until we can ensure that the substring is still valid.Also, keep on updating the mindistance accordingly.
We need to repeat this until we iterate over all the chars in s.
"""


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        tMap, sMap = {}, {}
        minLeft, minRight = 0, 0
        minDist = float('inf')
        required, length = len(t), len(s)
        left, right, formed = 0, 0, 0
        for char in t:
            if char in tMap:
                tMap[char] += 1
            else:
                tMap[char] = 1
        while right < length:
            while right < length and formed < required:
                curr = s[right]
                if curr in sMap:
                    sMap[curr] += 1
                else:
                    sMap[curr] = 1
                if curr in tMap and sMap[curr] <= tMap[curr]:
                    formed += 1
                right += 1
            while left < length and formed == required:
                currDist = right-left+1
                if currDist < minDist:
                    minDist, minLeft, minRight = currDist, left, right
                curr = s[left]
                sMap[curr] -= 1
                if curr in tMap and sMap[curr] < tMap[curr]:
                    formed -= 1
                left += 1
        if minLeft <= minRight:
            return s[minLeft:minRight]
        return ""
