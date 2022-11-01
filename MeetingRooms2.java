// Time Complexity : O(NLog(N))
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Sort the intervals based on 1st element,
insert in pq based on last element
if prev entry overflows then add curr and prev
else update prev last entry
* */
public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        int count=1;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });


        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] prev= pq.poll();
            int[] curr=intervals[i];
            if(prev[1]>curr[0]){
                pq.offer(prev);
                pq.offer(curr);
            }else{
                prev[1]=curr[1];
                pq.offer(prev);
            }
        }

        return pq.size();
    }
}
