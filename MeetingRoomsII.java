// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The minMeetingRooms method calculates the minimum number of meeting rooms required to accommodate a list of intervals, where each interval has a start and end time.
// It sorts the intervals based on their start times, uses a priority queue (min heap) to keep track of the end times of the meeting rooms in use, and checks if any room can be reused by comparing the start time of each interval with the earliest end time in the priority queue. The method returns the size of the priority queue, which represents the minimum number of meeting rooms needed to accommodate all the intervals.

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && (interval[0] >= pq.peek())) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        int[][] intervals = {
                { 0, 30 },
                { 5, 10 },
                { 15, 20 }
        };
        int minRooms = meetingRoomsII.minMeetingRooms(intervals);
        System.out.println("Minimum meeting rooms required: " + minRooms);
    }
}
