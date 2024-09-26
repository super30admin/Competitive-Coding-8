// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//
// Your code here along with comments explaining your approach
// 1. Start from end indexes of both strings.Now covert the character at respective index to integer.Make initial sum,carry as 0.
// 2. Now if sum/2 is greater then 2 then we will have a carry and change it to 1. If sum%2 == 0, then it means the current sum in 
//    binary without carry is 0.Add character 0 to result string,Else add one .Do this for all characters in both the arrays.
// 3. If characters in smaller strings are over ,then simply make value of character for smaller string for remaining iterations as 0.
// 4. Finally, if carry is one then add one to the string.Else,return string.

public class addBinary {
    public static String addBinary(String a, String b) {
        String result = "";
        int sum = 0,carry = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        while(i>=0||j>=0){
            int vala = 0;
            int valb = 0;
            if(i>=0 && j>=0){
                vala = a.charAt(i)-'0';
                valb = b.charAt(j)-'0';
            }
            else if(i>=0)   vala = a.charAt(i)-'0';
            else    valb = b.charAt(j)-'0';
            sum = carry+vala+valb;
            if(sum/2>0) carry = 1;
            else carry = 0;
            if(sum%2 == 0) result = '0'+result;
            else result = '1'+result;
            i--;j--;
        }
        if(carry == 1)  result = '1'+result;
        return result;
    }

    
    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        System.out.println(addBinary(a,b));
    }
}
