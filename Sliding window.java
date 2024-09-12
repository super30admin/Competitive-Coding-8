Time Complexity: O(n)
Space Complexity: O(n)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {		
		if (nums == null || k <= 0) { // I missed this edge case.
			return new int[0];
		}
		int n = nums.length;
		int[] result = new int[n-k+1];			
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {			
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}			
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}		
			q.offer(i);
			if (i >= k - 1) {
				result[i - k + 1] = nums[q.peek()];
			}
		}
		return result;
	}
}