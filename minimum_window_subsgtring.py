# Time Complexity :
# O(N)  - Size of the source string

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes


#We make a frequency map of the target string. We then try to check if any substring's frequency map contains all the required elements from target by comparing the frequency maps
#We do this by storing 2 pointers - slow and fast. The current substring being looked at is the one that starts at slow and ends at fast. We keep moving the fast until the frequency map of the substring has all the required elements in the current number is found. Then we keep moving the slow until this remains true. (At each point we check if the current substring length is the smallest seen until now)
#We do this until the fast has reached the end and slow cannot go any further without the current substring not having the required elements
#Then we return the smallest substring found until then

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_map = {}

        if len(t) > len(s):
            return ""

        #creating T_map
        for char in t :
            if char in t_map :
                t_map[char] += 1
            else :
                t_map[char] = 1

        slow = 0
        fast = 0
        count_match = 0
        shortest_subsring_len = 10**5 + 5
        loc1 = 0
        loc2 = 0
        temp_shortest = 0
        count_satisfied = False
        s_map = {}
        out_going_char = ""

        while (fast < len(s)) :
            new_char = s[fast]
            if new_char in t_map :
                if new_char in s_map :
                    s_map[new_char] += 1
                else :
                    s_map[new_char] = 1

                if s_map[new_char] == t_map[new_char] :
                    count_match += 1

                if count_match == len(t_map.keys()):
                    if fast - slow + 1 < shortest_subsring_len :
                        shortest_subsring_len = fast - slow + 1
                        loc1 = slow
                        loc2 = fast

            while count_match == len(t_map.keys()) and slow <= fast:
                out_going_char = s[slow]
                slow += 1
                if out_going_char in t_map :
                    s_map[out_going_char] -= 1
                    if fast - slow + 2 <= shortest_subsring_len :
                        shortest_subsring_len = fast - slow + 2
                        loc1 = slow - 1
                        loc2 = fast
                    if s_map[out_going_char] < t_map[out_going_char] :
                        count_match -= 1
                else :
                    if fast - slow + 1 < shortest_subsring_len :
                        shortest_subsring_len = fast - slow + 1
                        loc1 = slow
                        loc2 = fast

                
            fast += 1

        if shortest_subsring_len != 10**5 + 5:
            return s[loc1:loc2+1]
        else:
            return ""
       
