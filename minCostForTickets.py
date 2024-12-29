
# // Time Complexity :O(n) one pass on dp
# // Space Complexity :O(1) for 365 days dp array
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daySet = set(days)                              # search O(1)
        last = max(daySet)                              # last day

        dp = [0] * (last+1)                             # [0,2,2,2,4,4,7,7]  dp of size total days

        for i in range(1,last+1):
            if i not in daySet:                     # no travel day? same spent as previous day, continue       
                dp[i] = dp[i-1]                 
                continue
            dp[i] = min(                            # travel day?
                dp[i-1]+costs[0],                   # 1 day
                dp[max(i-7,0)]+costs[1],            # 7 day
                dp[max(i-30,0)]+costs[2]            # 30 day
            )

        return dp[last]
    
# i % 31 from 365 to 31
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daySet = set(days)
        last = days[-1]

        dp = [0] * 31
        for i in range(1,last+1):
            if i not in daySet:
                dp[i % 31]  = dp[(i-1) % 31]
                continue
            dp[i % 31] = min(
                dp[(i-1) % 31]+costs[0],
                dp[max(i-7,0) % 31]+costs[1],
                dp[max(i-30,0) % 31]+costs[2]
            )

        return dp[last % 31]