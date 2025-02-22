//TC => O(n^2logk)
//SC => O(n^2 - k)

public class Solution
{
    public int KthSmallest(int[][] matrix, int k)
    {
        if (matrix == null || matrix.Length == 0)
        {
            return 0;
        }

        int m = matrix.Length;
        int n = matrix[0].Length;

        PriorityQueue<int, int> pQueue = new PriorityQueue<int, int>();
        int count = n * n - (k - 1);
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                pQueue.Enqueue(matrix[i][j], matrix[i][j]);
                if (pQueue.Count > count)
                {
                    pQueue.Dequeue();
                }
            }
        }
        return pQueue.Dequeue();
    }
}