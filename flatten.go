// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root is nil return
set temp to root
if it has right child
if it has left child then set temp1 to left
go till the end on its right child
set temp1.right totemp.right
temp.right to temp.left
temp.left to nil
again call flatten on temp.right
else call flatten on temp.right

if temp.Left != nil then set temp.right to temp.left
set temp.left to nil and call flatten on temp.right
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode)  {
	if root == nil {
		return
	}
	temp := root

	if temp.Right != nil {
		if temp.Left != nil {
			temp1 := temp.Left
			for temp1.Right != nil {
				temp1 = temp1.Right
			}
			temp1.Right = temp.Right
			temp.Right = temp.Left
			temp.Left = nil
			flatten(temp.Right)
		} else {
			flatten(temp.Right)
		}
	}
	if temp.Left != nil {
		temp.Right = temp.Left
		temp.Left = nil
		flatten(temp.Right)
	}
}

func MainFlatten() {
	root := &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Left: &TreeNode{Val: 3}, Right: &TreeNode{Val: 4}}, Right: &TreeNode{Val: 5, Right: &TreeNode{Val: 6}}}
	flatten(root)
	temp := root
	for temp != nil {
		fmt.Println(temp.Val)
		temp = temp.Right
	}
}


