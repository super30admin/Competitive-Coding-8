// Time Complexity : O(n+m) n and m are length of strings s and t
// Space Complexity : O(n+m) n and m are length of strings s and t
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

import java.util.*;

class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0 || s.length()<t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        StringBuilder maxstr = new StringBuilder();
//         for(int j=0;j<s.length();j++){
//             if(map.containsKey(s.charAt(j))){
//                 int match = 0;
//                 for(int k=j+1;k<s.length();k++){

//                 }
//             }
//         }
        //System.out.println(map.get('a'));
        int slow=0; int fast=0;
        int match = 0;
        while(slow<s.length() && slow<=fast){
            if(match==map.size()){
                //found a valid substring;
                if(maxstr.length()!=0 && maxstr.length()>fast-slow){
                    maxstr = new StringBuilder(s.substring(slow,fast));
                }
                else if(maxstr.length()==0){
                    maxstr = new StringBuilder(s.substring(slow,fast));
                }
            }
            if((slow!=fast && match == map.size()) || fast==s.length()){
                if(map.containsKey(s.charAt(slow))){
                    int count = map.get(s.charAt(slow));
                    count++;
                    if(count==1){
                        match--;
                    }
                    map.put(s.charAt(slow),count);
                }
                slow++;
            }
            else{
                if(map.containsKey(s.charAt(fast))){
                    int count = map.get(s.charAt(fast));
                    //System.out.println(count);
                    count--;
                    if(count==0){
                        match++;
                    }
                    map.put(s.charAt(fast),count);
                }
                fast++;
            }


        }


        return maxstr.toString();
    }

    public static void main(String[] args){
        MinWindowSubstring ms = new MinWindowSubstring();
        System.out.println(ms.minWindow("ADOBECODEBANC", "ABC"));
    }
}