'''
76 Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t of lengths m and n respectively, return the minimum window of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?

Solution:
1. Brute Force + Hash Map:
for each i in range(M): # O(M)
    init hash<c, int> tracking freq count of chars in t
    for each j in range(i, M): # O(M)
        if hash[s[j]] > 0:
           match += 1
        hash[s[j]] -= 1

        if match == N:
            len = j - i + 1
            min_len = min(min_len, len)
return min_len
Time: O(M^2 + N), Space: O(1)

2. Sliding Window + Hash Map:
Step 0: Initialize the hash map by maintaining the freq count of characters in t. Init start and end pointers to 0 to traverse on s.
Step 1: Keep incrementing end pointer on s to form a substring (window = start:end) until we find the no. matching elements in s = len(t). We track the no. of matching elements using a hash map. Specifically, if the incoming character (s[end]) is a valid key in the map, then we decrease the freq count by 1. Only when the freq count of a char reaches 0, we increase the no. of matching elements by 1. (meaning we have found one character from t in the window)
Step 2: At this point, we shrink the window by incrementing the start pointer by 1 until the no. of matching elements in s falls 1 short of len(t). Specifically, if the outgoing character (s[start]) is a valid key in the map, then we increase the freq count by 1. Only when the freq count of a char  becomes a +ve no. (>0), we decrease the no. of matching elements by 1. (meaning we have lost one character from t in the window). Note that:
when freq count of a char (say 'a') is:
    a) +ve number (say 2), it means the window is short of 2 more instances of 'a'. Thus, the window is deficient.
    b) 0, it means the window has the same number of 'a's as the number of 'a's in t. Thus, the window is sufficient.
    c) -ve number (say -2), it it means the window has 2 instances of 'a' more than the instances of 'a' in t. Thus, the window is excessive.
Step 3: Repeat Step 1. Loop exits when end pointer goes past the last index of s.

Time: O(2N + M) = O(N+M), Space: O(1)


Note: We can check if the no. of matching elements in the substring (defined by the variable 'match'):
    Option 1: match == M
    Option 2: match == len(map)

Eg. If t = "ABC", then both M = 3, len(map) = 3 (map = {A: 1, B: 1, C: 1})
    If t = "AABC", then M = 4, but len(map) = 3 (map = {A: 2, B: 1, C: 1})

    Hence, use the following logic depending on whichever option we choose:
    a) Option 1: match == M:
        use:
            if freq[c] >= 0:
                match += 1
            .
            .
            while match == M:

    b) Option 2: match == len(map):
        use:
            if freq[c] == 0:
                match += 1
            .
            .
            while match == len(map):

'''
from collections import defaultdict
def minWindow(s: str, t: str) -> str:
    if not t:
        return ""
    N = len(s)
    M = len(t)
    if N < M:
        return ""

    freq =  defaultdict(int)
    for c in t: # O(M)
        freq[c] += 1
    start, end = 0, 0
    match = 0
    min_len = float('inf')
    result = ""
    while end < N: # O(N)
        c = s[end]
        if c in freq: # incoming char, decrease freq count
            freq[c] -= 1
            if freq[c] == 0: # alternative: freq[c] >=0
                match += 1

        while match == len(freq): # O(N), alternative: match == M
            l = end - start + 1
            if l < min_len:
                min_len = l
                result = s[start:end+1]
            c = s[start]
            if c in freq: # outgoing char, increase freq count
                freq[c] += 1
                if freq[c] > 0:
                    match -= 1
            start += 1

        end += 1
    return result

def run_minWindow():
    tests = [("DDAAABBCA", "ABC", "BCA"), ("ABABECAO", "AABC", "ABECA"), ("ADOBECODEBANC", "ABC", "BANC"), ("ABABECAO", "ABC", "ABEC"), ("a", "a", "a"), ("cabwefgewcwaefgcf", "cae", "cwae")]
    for test in tests:
        s, t, ans = test[0], test[1], test[2]
        substring = minWindow(s, t)
        print(f"\ns = {s}")
        print(f"t = {t}")
        print(f"Min Window Substring = {substring}")
        success = (ans == substring)
        print(f"Pass: {success}")
        if not success:
            return

run_minWindow()
