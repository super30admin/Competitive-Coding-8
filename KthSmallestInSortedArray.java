// Time Complexity : O(n * log(k)), where "n" is the number of elements in the matrix (i.e., n x n) and "k" is the difference between the maximum and minimum elements in the matrix.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The kthSmallest method finds the k-th smallest element in a 2D matrix, where each row and column is sorted in ascending order.
// It uses a binary search approach to find the k-th smallest element, narrowing down the search range by iteratively updating the left and right bounds.
// The helper method is used to count the number of elements less than or equal to a given value "mid" in the matrix, which helps in the binary search process.

public class KthSmallestInSortedArray {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];

        while (left != right) {
            int mid = left + (right - left) / 2;
            // for(int i =0; i<n; i++){

            int count = helper(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private int helper(int[][] matrix, int mid) {
        int count = 0;
        int col = matrix.length - 1;
        int row = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] <= mid) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestInSortedArray obj = new KthSmallestInSortedArray();
        int[][] matrix = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k = 8;
        int kthSmallestValue = obj.kthSmallest(matrix, k);

        System.out.println("The " + k + "th smallest element in the sorted matrix is: " + kthSmallestValue);
    }
}
