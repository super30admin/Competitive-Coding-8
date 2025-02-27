// Time complexity : 0(nlogn)
// Space Complexity : O(n)
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[][] meetings =  {{0,30}, {5,10},{15,20}};
        System.out.println(minMeetingRooms(meetings));
    }
    public static int minMeetingRooms(int[][] intervals){
        if(intervals.length == 0){
            return 0;
        }
        // Sort  my meetings
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] meeting : intervals){
            int start = meeting[0];
            int end = meeting[1];
            if(!pq.isEmpty() && pq.peek() <= start){
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }
}