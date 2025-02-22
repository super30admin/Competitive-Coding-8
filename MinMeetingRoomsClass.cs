// TC => O(nlogk)
// SC => O(k)

public class Solution
{
    public int MinMeetingRooms(int[][] intervals)
    {
        if (intervals == null || intervals.Length == 0)
        {
            return 0;
        }

        Array.Sort(intervals, (a, b) =>
        {
            if (a[0] == b[0])
            {
                return a[1].CompareTo(b[1]); // Sort by end time if start time is the same 
            }
            return a[0].CompareTo(b[0]); // Otherwise, sort by start time 
        });

        //[[4,9],[4,17],[9,10]]
        List<int[]> overlappingMeetings = new List<int[]>();
        overlappingMeetings.Add(intervals[0]);

        PriorityQueue<int[], int> pQueue = new PriorityQueue<int[], int>();
        pQueue.Enqueue(intervals[0], intervals[0][1]);
        for (int i = 1; i < intervals.Length; i++)
        {
            if (pQueue.Peek()[1] <= intervals[i][0])
            {
                pQueue.Dequeue();
            }
            pQueue.Enqueue(intervals[i], intervals[i][1]);
        }

        return pQueue.Count;
    }
}