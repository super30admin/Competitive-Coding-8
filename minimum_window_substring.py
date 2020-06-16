#Time Complexity: O(s+t), traversal and building hashmaps
#Space complexity: O(s+t),length of S and T

'''
Evertime we encounter a letter that belongs to T, we append it to a queue and
increment the hashmap with that key. We keep a hashmap to check how many times
the letter appear in T. If we've found all the letter of T, we check the
indices [slow,fast] and check if the length is better than our previous valid 
window. Then we pop from the queue to get the next position of slow, while decrementing
the value that moved from in the hashmap. If the letter count goes below
the number of that letter in T, we decrement found, since we need to find that letter
again. When fast goes out, we're done. We return the string from the optimal window
'''
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t)>len(s):
            return ''
        if len(t)==1:
            for c in s: 
                if c==t: return t 
            return ''
        
        letters={c:0 for c in t}
        letters_freq={c:0 for c in t}
        for l in t: letters_freq[l]+=1
            
        queue=collections.deque()
        slow=0
        min_=float("inf")
        window=None
        
        while slow<len(s) and s[slow] not in letters:
            slow=slow+1
        if slow==len(s): return ''
        fast=slow+1
        found=1
        letters[s[slow]]+=1
        was_found=False
        
        while fast<len(s):
            if s[fast] in letters and not was_found:
                queue.append((fast,s[fast]))
                if letters[s[fast]]<letters_freq[s[fast]]:
                    found+=1
                letters[s[fast]]+=1
            if found==len(t):
                if fast-slow<min_:
                    window=[slow,fast]
                    min_=fast-slow
                next_slow,next_slow_val=queue.popleft()
                letters[s[slow]]-=1
                if letters[s[slow]]<letters_freq[s[slow]]:
                    found-=1
                slow=next_slow
                was_found=True
                continue
                
            else: 
                was_found=False
                fast+=1
        if not window:
            return ''

        return s[window[0]:window[1]+1]
