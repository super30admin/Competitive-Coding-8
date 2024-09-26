import java.util.Arrays;
import java.util.PriorityQueue;
/*
Time Complexity: O(NlogN), N is the number of intervals in the given input, I would be sorting that, sorting would
count for NlogN
Space Complexity: O(N), using Priority Queue would cost O(N) complexity
Run on leetcode: yes
Any difficulties: No

Approach:
1. I will be sorting array based on begin time it would enable to schedule meetings, next I would use PriorityQueue to
add end interval, using priority queue would help me to sort the end time interval into ascending order too
2. Now I can compare begin time of the given interval and the peek element of the priority queue element, if the element is
less than begin time of the next interval we can use the same room to hold next meeting, then I have to poll the element
from the priority queue
3. At last the size of my priority queue would be the number of room I would need to accommodate meetings
 */

public class MeetingRoomsII {
    public static int meetingRooms(int[][] intervals){
        if(intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] interval: intervals){
            if(!pq.isEmpty() && pq.peek()<= interval[0]){
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args){
        int[][] intervals = {{0,30},{5,10},{15,20}};
        int[][] intervals1 = {{7,10},{2,4}};
        System.out.println("Total number of meeting rooms required: "+meetingRooms(intervals));
        System.out.println("Total number of meeting rooms required: "+meetingRooms(intervals1));
    }
}
