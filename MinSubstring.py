class Solution:
    def minWindow(self, s: str, t: str) -> str:
        
        #optimized solution - takes O(m+n) time
        #Space Complexity - O(m+n)
        
        queue= [] # To maintain all the indexes of characters of t found in s in the current window.
        # Using the queue we can reduce the window size every time by poping the first index in queue, when all the characters of t are found in current window.
        tchar = {}
        output = ""
        outputLen = float('inf')
        count = 0
        for char in t:
            if char not in tchar:
                tchar[char] = 1
            else:
                tchar[char] += 1
        
        for i in range(len(s)):
            if s[i] in tchar:
                tchar[s[i]] -= 1
                queue.append(i)
                if(tchar[s[i]] == 0):
                    count += 1
            while(count == len(tchar)):
                windowLen = i- queue[0] + 1
                if outputLen > windowLen:
                    output = s[queue[0]:i+1]
                    outputLen = windowLen
                removed = queue.pop(0)
                tchar[s[removed]] += 1
                if(tchar[s[removed]] > 0):
                    count -= 1
        return output
                        
