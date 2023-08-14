# Time complexity : O(n)
# Space complexity : O(t)

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        res = ""
        # check for empty string or s less than t, return empty string then
        if len(s) == 0 or len(t) == 0 or len(s) < len(t):
            return res
        
        n = len(s)
        seen = {}
        match = 0
        left = right = 0
        # building the frequency map of string t
        for ch in t:
            if ch in seen:
                seen[ch] += 1
            else:
                seen[ch] = 1
                
        m = len(seen)
        min_val = float('inf')
        
        # we travese until we cross left and right or we reach the left pointer till the end
        while left < right or left < n:
            # if we have all the characters from the hashmap, then find the min val
            if match == m:
                min_val = min(min_val, right - left)
                # if the min val we found is the current window, then update the resultant string
                if min_val == right - left:
                    res = s[left:right]
            
            # we check if left and right is not same and also match count is same as len of map or we have reached the end
            if (left != right and match == m) or right == n:
                # this is the outgoing element
                if s[left] in seen:
                    # if present in the map, then increment the value
                    seen[s[left]] += 1
                    # if value is 1, then simply decrement the match value by 1 only once for each char in map
                    if seen[s[left]] == 1:
                        match -= 1
                # increment the left pointer for other chars
                left += 1
                
            else:
                # for incoming char, if present in map, then decrement the count in map and increment match
                if s[right] in seen:
                    seen[s[right]] -= 1
                    if seen[s[right]] == 0:
                        match += 1
                # moving ahead in the string
                right+=1
        # return the minimum string we have found
        return res
