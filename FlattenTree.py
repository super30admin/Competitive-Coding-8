"""
The approach here is to do a simple pre-order traveral of the tree and connect the as nodes as per the
Requirement of the return answer.
Leetcode - Running
Space complexity - O(N)
"""
def flatten(self, root):
    q = [root]
    prev = None
    while q:
        node = q.pop()
        if node:
            q += [node.right,node.left]
            if prev:
                prev.left = None
                prev.right = node
            prev = node