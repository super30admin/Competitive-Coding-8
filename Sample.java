
// https://leetcode.com/problems/minimum-window-substring/description/
// Time Complexity : O(|s|+|t|)
// Space Complexity : O(t)
// Did this code successfully run on Leetcode : yes

class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
                return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int min=Integer.MAX_VALUE;
        int count=0;
        int left=0;
        int start=0;
        for(int right=0;right<s.length();right++)
        {
            char rch=s.charAt(right);  
            if(map.containsKey(rch))
            {
                if(map.get(rch)>0)
                {
                    count++;  
                }
                map.put(rch,map.getOrDefault(rch,0)-1);
            }
            while (count == t.length()) 
            { 
                if (right-left+1<min) {
                    min=right-left+1;
                    start=left;
                }
                char lch = s.charAt(left);
                if (map.containsKey(lch)) {
                    map.put(lch, map.get(lch) + 1);
                    if (map.get(lch) > 0) {
                        count--;
                    }
                }
                left++;
            }               
        }      
        return min==Integer.MAX_VALUE? "":s.substring(start, start+min);
    }
}



//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes


class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(curr.right != null) {
                stack.add(curr.right);
            }
            if(curr.left != null) {
                stack.add(curr.left);
            }
            if(!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }
}