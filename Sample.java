
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*****************PROBLEM-1******************/
//Kth Smallest Element in a Sorted Matrix
//TC:0(NlogK)
//SC:0(N)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null || matrix.length==0 || k==0){
            return 0;
        }

        PriorityQueue<Integer> heap=new PriorityQueue<>(Comparator.reverseOrder());

        for(int[] element:matrix){
            for(int each:element){
                if(heap.size()<k){
                    heap.add(each);
                }else if(heap.size()==k && each<heap.peek()){
                    heap.poll();
                    heap.add(each);
                }
            }
        }
        return heap.peek();
    }
}
/*****************PROBLEM-2******************/
//mEETING rOOM-2
//TC:0(NlogN)
//SC:0(N)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0 || intervals==null){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int[] interval:intervals){
            if(!heap.isEmpty() && heap.peek()<=interval[0]){
                heap.poll();
            }
            heap.add(interval[1]);
        }
        return heap.size();
    }
}