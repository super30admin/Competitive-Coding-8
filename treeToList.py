#Using recursive dfs to solve this problem
#Time Complexity: O(h)
#Space Complexity: O(1)
class TreeNode:
    def __init__(self,data):
        self.data = data
        self.left = None
        self.right = None

class Tree:
    def __init__(self):
        self.current = None

    def start(self,node):
        
        if node is None:
            return
        else:
            self.current = node
        self.helper(node)

    def helper(self,node):
        if node is None:
            return
        lef = node.left
        rig = node.right
        node.left = None
        node.right = None
        if self.current != node:
            self.current.left = node
            self.current = node
        self.helper(lef)
        self.helper(rig)

    def traverse(self,node):
        if node is None:
            return
        print(node.data)
        self.traverse(node.left)
        self.traverse(node.right)


n1 = TreeNode(1)
n2 = TreeNode(2)
n3 = TreeNode(5)
n4 = TreeNode(3)
n5 = TreeNode(4)
n6 = TreeNode(6)
n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5
n3.right = n6
t = Tree()
t.start(n1)
t.traverse(n1)
