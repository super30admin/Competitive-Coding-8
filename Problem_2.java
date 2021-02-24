// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public String minWindow(String s, String t) {
        int[] arr=new int[3];
        arr[0]=-1;
        HashMap<Character,Integer> dict=new HashMap<>();
        for(char st:t.toCharArray()){
            dict.put(st,dict.getOrDefault(st,0)+1);
        }
        int required=t.length();
        int formed=0;
        int i=-1;
        int j=-1;
        HashMap<Character,Integer> hash=new HashMap<>();
        while(true){
            boolean flag1=true;
            boolean flag2=true;
            while(j<s.length()-1 && formed<required){
				j++; 
                char ch=s.charAt(j);
                hash.put(ch,hash.getOrDefault(ch,0)+1);
                if(hash.getOrDefault(ch,0)<=dict.getOrDefault(ch,0)){
                    formed=formed+1;
                }
     
                flag1=false;
            }
            while(i<j && formed==required){
               //System.out.println("hi");
                //System.out.println(s1.substring(i,j+1));
                if(arr[0]==-1){
                    arr[0]=j-i+1;
                    arr[1]=i;
                    arr[2]=j;
                }else if((j-i+1)<arr[0]){
                    arr[0]=j-i+1;
                    arr[1]=i;
                    arr[2]=j;
                }
				i++;
                char ch=s.charAt(i);
                if(hash.get(ch)==1){
                    hash.remove(ch);
                }else{
                    hash.put(ch,hash.get(ch)-1);
                }
                if(hash.getOrDefault(ch,0)<dict.getOrDefault(ch,0)){
                    formed=formed-1;
                }
                flag2=false;
            }
            if(flag1 && flag2){
                break;
            }
        }
        //System.out.println(Arrays.toString(arr));
        return s.substring(arr[1]+1,arr[2]+1);
    }
}

/////There can be one be one more solution.
class Solution {
    public String minWindow(String s, String t) {
        int[] arr=new int[3];
        HashMap<Character,Integer> dict=new HashMap<>();
        for(char c:t.toCharArray()){
            dict.put(c,dict.getOrDefault(c,0)+1);
        }
        arr[0]=-1;
        int i=0;
        int j=0;
        int formed=0;
        int required=dict.size();
        HashMap<Character,Integer> hash=new HashMap<>();
        while(i<s.length()){
            char ch=s.charAt(i);
            hash.put(ch,hash.getOrDefault(ch,0)+1);
            if(dict.containsKey(ch) && hash.get(ch)==dict.get(ch)){
                formed=formed+1;
            }
            while(j<=i && formed==required){
                //System.out.println(i+","+j);
                if(arr[0]==-1 || (i-j+1)<arr[0]){
                    arr[0]=i-j+1;
                    arr[1]=j;
                    arr[2]=i;
                }
                ch=s.charAt(j);
                hash.put(ch,hash.get(ch)-1);
                if(dict.containsKey(ch) && hash.get(ch)<dict.get(ch)){
                    formed=formed-1;
                }
                 j++;
                    
            }
            i++;
            
        }
        return arr[0]==-1?"":s.substring(arr[1],arr[2]+1);
    }
}