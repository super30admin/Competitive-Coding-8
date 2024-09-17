
// Time Complexity : O(length of s + length of t)
// Space Complexity : O(1) considering the auxiliary string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public String minWindow(String s, String t) {
        int[] arr=new int[256];
        int count=t.length(),left=0,len=Integer.MAX_VALUE;
        String result="";
        for(Character ch:t.toCharArray())
            arr[ch]++;
        
        for(int right=0;right<s.length();right++){
            Character ch = s.charAt(right);
            if(arr[ch]-->0)
                count--;
            
            while(count==0){
                Character chLeft = s.charAt(left);
                int prevLen = len;
                len=Math.min(right-left+1,len);
                
                if(len!=prevLen)
                    result=s.substring(left,right+1);
                if(arr[chLeft]++==0)
                    count++;
                left++;
            }
        }
        return len==Integer.MAX_VALUE?"":result;
    }
}
