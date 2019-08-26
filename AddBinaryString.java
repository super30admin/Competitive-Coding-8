//Approach is to covert each binary digit from right to left to int and then add digits of both string and carry.
//if sum>1 then sum= sum%2 
//carry = sum/2 .at the end just append carry to result
//tc:o(a+b)
//sc:0(a+b)
public class AddBinaryString {
	class Solution {
	    public String addBinary(String a, String b) {
	        StringBuilder result = new StringBuilder();
	        int i =a.length()-1;
	        int j= b.length()-1;
	        int sum =0;
	        int carry =0;
	        while(i>=0 || j>=0){
	            int valueA =0;
	            int valueB =0;
	            if(i>=0 && j<0){
	               valueA = a.charAt(i) - '0';
	            }else if(j>=0 && i<0){
	               valueB = b.charAt(j) - '0';
	            }else if(i>=0 && j>=0){
	               valueA = a.charAt(i) - '0';
	               valueB = b.charAt(j) - '0';
	            }
	            sum = valueA + valueB + carry;
	            carry = sum/2;
	            if(sum >1){
	                sum = sum%2;
	            }
	            result.append(sum);
	            System.out.println("sum"+sum);
	           
	            i--;
	            j--;
	        }
	        if(carry>0){
	            result.append(carry);
	        }
	        return result.reverse().toString();
	    }
	}

}
