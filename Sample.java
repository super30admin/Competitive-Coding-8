// Problem-1: Minimum Window Substring
/**
Sliding window technique. 
TC = O(n) where n is the len of the s string
SC = O(1) storing at max 52 chars
*/





/** CAN YOU PLEASE EXPLAIN WHY .inValue() is necessary to use on line 40. It is failing the last test case without it*/





class Solution {
    static class info{
         int start;
         int end;
          int len;
    }
    public String minWindow(String s, String t) {
        
        if(s == null ||s.length() == 0 || s == null ||s.length() == 0) return "";
        if(t.length() > s.length()) return "";
        
        int match=0;
        int left=0;
        info answer = new info();
        answer.len = -1;
        answer.start = -1;
        answer.end = -1;
        
        
        HashMap<Character, Integer> tMap = new HashMap<>(); 
        HashMap<Character, Integer> window = new HashMap<>();
        
        for(char c: t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        for(int right=0; right < s.length(); right++){ 
            
            char in = s.charAt(right); 
            if(tMap.containsKey(in)){
                window.put( in, window.getOrDefault(in, 0) +1);  // only storing values in the window that are in the t string
            }
            
           if(tMap.containsKey(in) && window.get(in).intValue() == tMap.get(in).intValue()){
                match++;
            }
            while(left <= right && match == tMap.size() ){ 
                if( answer.len == -1 || right - left+1 < answer.len){ 
                    answer.start = left;
                    answer.end = right;
                    answer.len = (right - left)+1;
                }
                    char out = s.charAt(left++);
                if(window.containsKey(out)){
                    int count = window.get(out)-1;
                    if(tMap.get(out) != null && count < tMap.get(out)){
                        match--;
                    } 
                    window.put(out, count);
                }
            }
            
        }

        return answer.start == -1 ? "":s.substring(  answer.start, answer.end+1);
    }
}

// Problem-2: 114. Flatten Binary Tree to Linked List
/**
Competetive coding: Iteratvie stack solution
TC = O(n)
SC = O(h) height of the tree
*/
class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        // 1->2->3->4->5->6
        while(!s.isEmpty()){ // 1
            
            TreeNode cur = s.pop(); // 1, 2, 3, 4, 5
            
            if(cur.right != null) s.push(cur.right); 
            if(cur.left != null) s.push(cur.left); // [6]
            if(!s.isEmpty()){
                cur.right = s.peek(); // 1->2->3->4->5->6
                cur.left = null;
            }
            
        }
        
        
    }
}
