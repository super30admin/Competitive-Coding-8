# tc O(n), sc O(1).
left = 0
sdict = defaultdict(int)
tdict = defaultdict(int)
for char in t:
    tdict[char] += 1
minlength = float('inf')
start, end = -1, -1

for right in range(len(s)):
    sdict[s[right]] += 1

    while left <= right and all(tdict[x] <= sdict[x] for x in tdict):
        sdict[s[left]] -= 1
        if sdict[s[left]] == 0:
            del sdict[s[left]]
        left += 1
    
    if left > 0:
        if right-left+2 < minlength:
            minlength = right-left+2
            start, end = left - 1, right

return s[start:end+1] if start != -1 else ""
