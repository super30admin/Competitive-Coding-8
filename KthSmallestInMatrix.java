// Time Complexity : O(NLog(Range))
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Binary search. Find the rank of the element and based on that reduce search space (Range of elements)
*/
public class KthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(k>matrix.length*matrix[0].length) return -1;

        //Binary search on range
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];

        while(low<high){
            int mid=low+(high-low)/2;
            int rank= getRank(matrix,mid);
            if(rank<k) low=mid+1;
            else high=mid;
        }

        return low;
    }

    private int getRank(int[][] matrix, int target){
        int count=0, n= matrix.length;
        //start from bottom left
        int row= n-1, col=0;
        while(row>=0 && col<n){
            if(matrix[row][col]>target) row--;
            else{
                count+= row+1;
                col++;
            }
        }
        return count;
    }
}
