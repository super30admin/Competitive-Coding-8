// TC: O((N+K)logN)
// SC: O(N)

import java.util.PriorityQueue;

public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int i=0;i<n;i++){
            pq.offer(new int[]{i, 0});
        }
        while(k>1){
            int[] poll = pq.poll();
            if(poll[1]<n-1) pq.offer(new int[]{poll[0], poll[1]+1});
            k--;
        }
        return matrix[pq.peek()[0]][pq.peek()[1]];
    }
}
