"""

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.


Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 10^4
0 <= starti < endi <= 10^6


Time Complexity: O(n log n) (due to sorting the start and end times).  
Space Complexity: O(n) (for storing the sorted start and end times).  

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# 1. Sort the start and end times of meetings separately to track room allocation.  
# 2. Use two pointers (s for start times, e for end times) and iterate through the start times, incrementing count when a meeting starts and decrementing when a meeting ends.  
# 3. The maximum count at any point during this process represents the minimum number of meeting rooms required.  


class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:

        start = sorted(i[0] for i in intervals)
        end = sorted(i[1] for i in intervals)

        s, e = 0, 0

        count = 0
        res = 0

        while s < len(intervals):

            if start[s] < end[e]:
                count += 1
                s += 1

            else:
                count -= 1
                e += 1

            res = max(res, count)

        return res

