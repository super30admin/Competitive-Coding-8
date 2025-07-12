# sliding window: two pointers: 1 hasmap: 1 counter
#Time = O(m+n) where m is length of t and n is length of s. m is usually smaller hence time complexity = O(n)
#Space = O(n) for hashmap
#Use a hashmap to store the frequency of each character in t and use two pointers to define a sliding window on s.
#Expand the right pointer to include characters, updating the count when a needed character is found.
#When all characters from t are matched, move the left pointer to minimize the window and update the result if a smaller valid window is found.


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        mapT = {}
        #Put characters and their frequencies in hashmapT
        for char in t:
            mapT[char] = 1+mapT.get(char,0)

        count = 0
        result = ""
        result_length = float('inf')
        left = 0
        #right = 0

        for right in range(len(s)):
            char = s[right]
            if char in mapT:
                mapT[char] -= 1
                if mapT[char] >= 0: #for duplicates in t
                    count += 1

            while count == len(t):
                window_length = right - left + 1
                if window_length < result_length:
                    result_length = window_length
                    result = s[left:right+1]

                #srinking left
                left_char = s[left]
                if left_char in mapT:
                    mapT[left_char] += 1
                    if mapT[left_char] > 0:
                        count -= 1
                left += 1

        return result

