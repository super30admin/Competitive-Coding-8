# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)


class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        q=deque([(0,0)])
        l=len(nums)-1
        res=[]
        while q:
            i,j=q.popleft()
            res.append(nums[i][j])
            if i<l and j==0:
                q.append((i+1,j))
            if j<len(nums[i])-1:
                q.append((i,j+1))
        return res