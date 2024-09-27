class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        tHashmap ={}
        # Hashmap from T - to count freq
        for ch in t:
            if ch not in tHashmap:
                tHashmap[ch] = 1
            else:
                tHashmap[ch]+=1
        length = len(tHashmap)
        match = 0
        minlength = float("inf")
        minstart = 0
        start = 0
        windowsize = 0
        for end in range(len(s)):
            ch = s[end]
            if ch in  tHashmap:
                tHashmap[ch]-=1
                if tHashmap[ch] ==0:
                    match+=1
            while(match == length):
                windowsize = end - start + 1 
                if windowsize<minlength:
                    minlength = windowsize
                    minstart = start
                shrink = s[start]
                if shrink in tHashmap:
                    if tHashmap[shrink]==0:
                        match -=1
                    tHashmap[shrink] +=1
                # move the start of the window
                start += 1
        print(minstart)
        print(minlength)
        if minlength == float("inf"):
                result = ""
        else:
            result = s[minstart: minstart+minlength]
        return result