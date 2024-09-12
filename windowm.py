def minWindow(self, s: str, p: str) -> str:

    min_len = math.inf
    i_left = 0
    d = collections.defaultdict(int)
    i_left_min = 0
    i_right_min = -1
    
    for i in range(len(p)):
        d[p[i]] -= 1

    for i_right in range(len(s)):

        if s[i_right] in d:
            d[s[i_right]] += 1

        while i <= len(s)-2:
            if s[i_left] in d and d[s[i_left]] > 0:
                d[s[i_left]] -= 1
                i_left += 1
            elif s[i_left] not in d:
                i_left += 1
            else:
                break
            i += 1   

        if min(d.values()) >= 0 and i_right - i_left < min_len:
            min_len = i_right - i_left
            i_left_min = i_left
            i_right_min = i_right


    return s[i_left_min:i_right_min+1]  