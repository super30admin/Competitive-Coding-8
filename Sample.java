//Problem 1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Push all left node subtree in right side. rightmost node of left subtree will link to root right. and root right to root left
class Solution {
    // TreeNode prev=null;
    public void flatten(TreeNode root) {
        //base
        if(root==null) return;
        //O(n) O(n)
        // flatten(root.right);
        // flatten(root.left);

        // root.right=prev;
        // root.left=null;
        // prev=root;

        //O(n) O(1)
        TreeNode node= root;
        while(node!=null){

            if(node.left!=null){
                TreeNode r=node.left;
                while(r.right!=null) r=r.right;

                r.right=node.right;
                node.right=node.left;
                node.left=null;
            }

            node=node.right;
        }
    }
}

//Problem 2
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//Sliding window mechanism, find all substrings that have characters from t and check if the length of substring is minimum.
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap=new HashMap<>();

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        int match=0, start=0, minLength=Integer.MAX_VALUE,substrStart=0;

        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);

            if(tmap.containsKey(cur)){
                tmap.put(cur,tmap.get(cur)-1); 
                if(tmap.get(cur)==0)
                    match++;
            }

            while(match==tmap.size()){

                if(minLength>i-start+1){//found a new minLength
                    minLength=i-start+1;
                    substrStart=start;
                }

                char del=s.charAt(start++);
                if(tmap.containsKey(del)){
                    if(tmap.get(del)==0)
                        match--;
                    tmap.put(del,tmap.get(del)+1);
                }
            }

        }
        return minLength>s.length() ? "": s.substring(substrStart,substrStart+minLength);   
    }
}