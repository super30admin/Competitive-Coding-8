# Time = O(nlogn), Space =o(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start, end = [], []
        for each in intervals:
            start.append(each[0])
            end.append(each[1])
        
        start = sorted(start)
        end = sorted(end)
        i, j = 0, 0
        rooms = 0
        while i < len(intervals):
            if start[i] < end[j]:
                rooms += 1
                
                
            else:
                j += 1
            i += 1
        return rooms
        