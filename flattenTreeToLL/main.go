/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode)  {
    
    // base
    if root == nil {
        return
    }
    
    //logic
    flatten(root.Left)
    flatten(root.Right)
    if root.Left != nil {
        tmp := root.Right
        root.Right = root.Left
        root.Left = nil
        // go right as much as possible to get to the tail end of the linkedlist
        for root.Right != nil {
            root = root.Right
        }
        // once we have reached the tail end, set the tail.Right to tmp ( prev right )
        root.Right = tmp
    }
    
}
