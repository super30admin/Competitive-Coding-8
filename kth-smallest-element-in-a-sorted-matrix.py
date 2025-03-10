"""

Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 
Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2

 
Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.


Time Complexity: O(n log(max-min)), where n is the number of rows or columns.
Space Complexity: O(1), as only a few integer variables are used.

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach:
# 1. Use binary search between the smallest and largest elements in the matrix.
# 2. For each mid value, count elements ≤ mid using a two-pointer traversal from the bottom-left.
# 3. Adjust the search range based on the count until we find the kth smallest element.


class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:

        n = len(matrix)

        low, high = matrix[0][0], matrix[-1][-1]

        def countLessthan(mid):
            
            count = 0

            row, col = n-1, 0

            while row >= 0 and col < n:
                if matrix[row][col] <= mid:
                    count += row + 1
                    col += 1
                else:
                    row -= 1

            return count


        while low < high:
            mid = (low+high) // 2
            
            if countLessthan(mid) < k:
                low = mid + 1
            else:
                high = mid

        return low
