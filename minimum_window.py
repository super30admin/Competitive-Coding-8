class Solution:
    def minWindow(self, s: str, t: str) -> str:
        from collections import defaultdict
        length=float('inf')
        start,end=0,0

        map=defaultdict(int)
        for c in t:
            map[c]+=1
        
        slow=0
        match=0
        length=float('inf')

        for i in range(len(s)):
            in_char=s[i]
            if in_char in map:
                frq=map[in_char]
                frq-=1
                map[in_char]=frq
                if frq==0:
                    match+=1
            if match<len(map):
                continue
            
            while match==len(map):
                out_char=s[slow]
                slow+=1
                if out_char in map:
                    frq=map[out_char]
                    frq+=1
                    map[out_char]=frq
                    if frq==1:
                        match-=1
            if length>i-slow+2:
                length=i-slow+2
                start=slow-1
                end=i
        if length==float('inf'):
            return ""
        return s[start:end+1]

