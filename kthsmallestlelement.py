#--------------Using Max Heap------------------------------------------
#*************ThumbRule - If asked to find kth smallest element use max heap of k elements
# or min heap of (n-k) elements but take care of how to output result, n = total elements
#Time = O(nlog(k)), Space=O(k)
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        lst = []
        m = len(matrix)
        n = len(matrix[0])

        length = m*n
        result = -999999999
        for i in range(length):
            row = i // n
            col = i % n
            # Negative indicates max heap
            heapq.heappush(lst, -matrix[row][col])
            if len(lst) > k:
                heapq.heappop(lst)
        return heapq.heappop(lst) # At the end the top element





#---------------------Using min heap of n - k elements------------
# We have to take max of upcoming elements and element on the top of the heap to get our answer
#Time = O(nlog(n-k)), Space=O(n-k)

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        lst = []
        m = len(matrix)
        n = len(matrix[0])

        length = m*n
        result = -999999999
        for i in range(length):
            row = i // n
            col = i % n
            heapq.heappush(lst, matrix[row][col])
            if len(lst) > length - k:
                result = max(result, heapq.heappop(lst))
        return result
        