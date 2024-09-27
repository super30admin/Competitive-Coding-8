import java.util.*;
public class CompetitiveCoding {
    public class TreeNode{
        int val;
       TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
     // time complexity : N
    // space complexity : N
    // any doubts : no
    // did it run on leetcode : yes
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
    List<TreeNode> path;
    public void flatten(TreeNode root) {
        if(root == null) return;
        path = new ArrayList<>();
        helper(root);
        for(int i =0;i<path.size()-1;i++){
            path.get(i).right = path.get(i+1);
            path.get(i).left = null;
        }
        
    }
    private void helper(TreeNode root){
        if(root == null) return;
        path.add(root);
        helper(root.left);
        helper(root.right);
    }

     // time complexity : N
    // space complexity : N
    // any doubts : no
    // did it run on leetcode : yes
    //https://leetcode.com/problems/minimum-window-substring/
    public String minWindow(String s, String t) {
        //null check
        if(s== null || t== null || s.length()==0 || t.length()==0) return "";
        //variables
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0;
        int j =0;
        int start = 0;
        int end = s.length()-1;
        int max = 0;
        int count=0;
        //create map
        for(int k =0;k<t.length();k++){
            char p = t.charAt(k);
            if(!map.containsKey(p)){
                map.put(p,1);
            }else{
                map.put(p,map.get(p)+1);
            }
        }
        
        //logic
        while(i<s.length()){
            char m = s.charAt(i);
            i++;
            if(map.containsKey(m)){
                map.put(m,map.get(m)-1);
                if(map.get(m)==0){
                    count++;                
                }
            }  
            while(count == map.size() && j<=i){
                char o = s.charAt(j);
                j++;
                if(map.containsKey(o)){
                    map.put(o,map.get(o)+1);
                     if(map.get(o)>0){
                     count--;                
                }
                                  
                }
                
                if(i-j+1 > max){
                start = i;
                end = j;
                max = i-j+1;
            }
               
            }
            
             
        }
        
        return s.substring(end-1,start);
    }
}
