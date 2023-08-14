class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # # Brute Force Approach
        # res = []
        # n = len(t)
        # count = n
        # t_map = defaultdict(int)
        # for ch in t:
        #     t_map[ch] += 1

        # start, end = 0, 0
        # copy_t_map = deepcopy(t_map)
        # while end < len(s):
        #     if s[end] in t_map:
        #         # Check if t_map count goes below 0 sometimes
        #         if t_map[s[end]] > 0:
        #             t_map[s[end]] -= 1
        #             count -= 1
        #             # Check if count went to 0, then record the substring
        #             if count == 0:
        #                 # res.append(s[start:end+1])
        #                 res.append([start,end])
        #                 count = n
        #                 t_map = deepcopy(copy_t_map)
        #                 start = start + 1
        #                 end = start
        #                 continue
        #     else:
        #         if count == n:
        #             start = end+1
        #     end += 1
        # print(res)
        # if not res:
        #     return ''

        # ans_idx = []
        # ans = float('inf')
        # # print(ans)
        # for i in res:
        #     # print(i[1] - i[0])
        #     if ans > (i[1] -i[0]):
        #         ans = (i[1] -i[0])
        #         ans_idx = [i[0], i[1]]
        # # print(ans_idx)
        # # print("ANS", ans)
        # # print("ANS idx", ans_idx)
        # return s[ans_idx[0]: ans_idx[1]+1]

        # Optimised Approach
        # Time O(n)
        # Space O(n)
        if t == '': return ''
        if len(t) > len(s):
            return ''
        countT, window = {}, {}

        for c in t:
            countT[c] = 1 + countT.get(c, 0)

        have, need = 0, len(countT)
        l = 0
        res, reslen = [-1, -1], float('inf')

        for r in range(len(s)):
            c = s[r]
            window[c] = 1 + window.get(c, 0)

            if c in countT and window[c] == countT[c]:
                have += 1

            while have == need:
                if (r - l) + 1 < reslen:
                    res = [l, r]
                    reslen = (r - l) + 1
                # Pop from left side of window
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1

        return s[res[0]: res[1] + 1] if reslen != float('inf') else ''






























