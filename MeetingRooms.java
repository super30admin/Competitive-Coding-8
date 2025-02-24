// TC: O(NlogN)
// SC: O(N)
// where N is the number of intervals

import java.util.*;

/**
 * Definition of Interval:
 * public class Interval {
 * public int start, end;
 * public Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MeetingRooms {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) minHeap.poll();
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
