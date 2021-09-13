//Time Complexity: O(n)
//Space Complexity: O(m) Where m is the length of test string
class Solution {
    public String minWindow(String s, String t) {
        if(s==null||s.length()==0||t.length()==0||s.length()<t.length())
            return "";
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
            char temp=t.charAt(i);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        int fp=0,bp=0;
        int charRequired=t.length();
        int leftBoundary=0,rightBoundary=0;
        int minLength=Integer.MAX_VALUE;
        boolean flag=false;
        while(fp<s.length()){
            char currChar=s.charAt(fp);
            if(map.containsKey(currChar)){
                map.put(currChar,map.get(currChar)-1);
                if(map.get(currChar)>=0)
                    charRequired--;
            }
            
            // if(charRequired==0 && bp<=fp){
            while(charRequired==0 && bp<=fp){
                // System.out.println("HI1");
                flag=true;
                int currLength=fp-bp+1;
                if(currLength<=minLength){
                    // System.out.println("HI");
                    leftBoundary=bp;
                    rightBoundary=fp;
                    minLength=currLength;
                }
                char backLetter=s.charAt(bp);
                if(map.containsKey(backLetter)){
                    map.put(backLetter,map.get(backLetter)+1);
                    if(map.get(backLetter)>=1){
                        charRequired++;
                    }
                }
                bp++;
            }
            // }
            fp++;
        }
        return flag==true?s.substring(leftBoundary,rightBoundary+1):"";
    }
}