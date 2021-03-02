# Time Complexity : O(N+K+KLogK)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I use the min heap approach where I add the right and bottom element to a min heap, then I remove the min element and process its neighbors. After K
# steps we will reach the k smallest item

from heapq import heappush, heappop
class Element:
    def __init__(self, val, row, col, n):
        self.val = val
        self.row = row
        self.col = col
        self.mapping = (self.row*n) + self.col
        
    def __eq__(self, other):
        return self.val == other.val
    
    def __le__(self, other):
        return self.val <= other.val
    
    def __ge__(self, other):
        return self.val >= other.val
    
    def __lt__(self, other):
        return self.val < other.val
    
    def __gt__(self, other):
        return self.val > other.val

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        s = set()
        heap = []
        popped = 0
        last_popped = None
        e = Element(matrix[0][0], 0, 0, len(matrix))
        s.add(e.mapping)
        heappush(heap, e)

        while popped < k and len(heap):
            element = heappop(heap)
            last_popped = element
            popped+=1
            print(popped, last_popped.val)
            #right
            right_element_row = element.row 
            right_element_col = element.col + 1
            if right_element_col < len(matrix):
                right_element = Element(matrix[right_element_row][right_element_col], 
                                        right_element_row,
                                        right_element_col,
                                        len(matrix)
                                       )
                if right_element_col < len(matrix) and right_element.mapping not in s:
                    heappush(heap, right_element)
                    s.add(right_element.mapping)
                
            #down
            down_element_row = element.row + 1
            down_element_col = element.col
            if down_element_row < len(matrix):
                down_element = Element(matrix[down_element_row][down_element_col], 
                                        down_element_row,
                                        down_element_col,
                                        len(matrix)
                                       )
                if down_element.mapping not in s:
                    heappush(heap, down_element)
                    s.add(down_element.mapping)
                
            
            
        return last_popped.val
            
        
        
