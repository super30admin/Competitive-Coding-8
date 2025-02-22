//TC => O(n^2logn^2)
//SC => O(n^2)

public class Solution
{
    public class MaxHeap : IComparer<int>
    {
        public int Compare(int x, int y)
        {
            return y.CompareTo(x);
        }
    }
    public int KthSmallest(int[][] matrix, int k)
    {
        if (matrix == null || matrix.Length == 0)
        {
            return 0;
        }

        int m = matrix.Length;
        int n = matrix[0].Length;

        PriorityQueue<int, int> pQueue = new PriorityQueue<int, int>(new MaxHeap());
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                pQueue.Enqueue(matrix[i][j], matrix[i][j]);
            }
        }
        while (pQueue.Count > k)
        {
            pQueue.Dequeue();
        }
        return pQueue.Dequeue();
    }
}