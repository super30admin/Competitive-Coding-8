#time complexity: O(n)
#space complexity: O(n)
'''
Attach to the last element in the pre order traversal that is
on the left tree of root the right subtree. We return to the
root and perform another pre-order traversal , while appending
to the right the elements in the traversal one by one. By
moving the right subtree, we make sure the traversal is the same
while being to append to the right without messing up the tree
'''
class Solution:
    def flatten(self, root: TreeNode) -> None:
        if not root:
            return root
        st=[]
        node=root
        st.append(node)
        prev=TreeNode(0)
        if not root.left:
            root.left=root.right
            root.right=None
        if root.right:
            while st:
                node=st.pop()
                #recurse
                if node.right:
                    st.append(node.right)
                if node.left:
                    st.append(node.left)
                #(node!=root.left or (not root.left.left and not root.left.right))
                if st and st[-1]==root.right:
                    node.right=root.right
                    break
            root.right=None
        
        st=[]
        node=root
        st.append(node)
        prev=TreeNode(0)
        while st:
            node=st.pop()
            prev.right=node
            #recurse
            if node.right:
                st.append(node.right)
            if node.left:
                st.append(node.left)
            node.right,node.left=None,None
            prev=node
        root.left=None
        
        
#Time complexity: O(n)
#Space Complexity: O(n) , recursive stack
'''
flatten left subtree, flatten right subtree. We keep in a temp the right subtree
then we attach to the right of root the left subtree (flatten), then move
right until we reach the end of that subtree. Then we attach the saved
flatten right subtree. We don't forget to detach left subtree.
We do this recursively.
'''
class Solution:
    def flatten(self, root: TreeNode) -> None:
        def helper(root):
            if not root:
                return
            helper(root.left)
            helper(root.right)
            
            temp=root.right
            root.right=root.left
            root.left=None
            node=root
            while node.right:
                node=node.right
            node.right=temp
            
        helper(root)    
