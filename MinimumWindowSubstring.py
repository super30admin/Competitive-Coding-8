class Solution(object):
    # tc : O(s+t) t for creating the intial hashmap, 2s as we visit each s character atmost twice in the loop iteration
    # sc : O(s+t) count maps for both takes this space complexity 
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        # hasmap of saving the letter and it count of t 
        # use a sliding window where we stat from using two pointers left and right 
        # start left and right same position and move thr right until we found all the characterd and the frequncy of the character thus getign a window , save the strinf as output
        # next lets move left to the next pointer and see with this current window the desierd characters were there or not if not then we keping movng the rigth window
        # will do this until we reach left to the end of the arr

        hash_map_t = {}
        swindow_map = {}

        for i in range(len(t)):
            if t[i] not in hash_map_t:
                hash_map_t[t[i]] = 0
            hash_map_t[t[i]]+=1

        left, right = 0,0
        output = [float("inf"),""]

        t_required = len(hash_map_t)
        window_formed = 0

        while right < len(s):
            character = s[right]
            swindow_map[character] = swindow_map.get(character, 0) + 1

            if character in hash_map_t and swindow_map[character] == hash_map_t[character]:
                window_formed+=1
            
            while left <= right and window_formed == t_required : # until then we will keep reducign our window by moving our left pointer and see ifits still valid
                substr = s[left:right+1]
                # but is this is the minimum window 
                if len(substr) < output[0]: # our current string is the smaller window
                    output = [len(substr), substr]
                
                # once window checked lets now check by moving left one step still its a correct window but before that we have to remove the left chracter in our hashmap or reduce its count
                left_char = s[left]
                swindow_map[left_char] -= 1
                
                if left_char in hash_map_t and swindow_map[left_char] < hash_map_t[left_char]:
                    window_formed -= 1

                left +=1 
            
            right +=1 # so we move the right ppinter by 1 step to find the characters

        return output[1]

                





            