//Time Complexity: O(m+n) ; m is length of s and n is length of t
//Space Complexity: O(1)
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        String result="";
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mapT.put(t.charAt(i),mapT.getOrDefault(t.charAt(i),0)+1);
        }
        int match = 0;
        int i=0;
        int j=0;
        HashMap<Character,Integer> mapS = new HashMap<>();

        while(true)
        {
            Boolean b1= false;
            Boolean b2= false;
            while(j<s.length() && match<t.length() ){

                mapS.put(s.charAt(j),mapS.getOrDefault(s.charAt(j),0)+1);
                if(mapT.containsKey(s.charAt(j)) && mapS.get(s.charAt(j)) >= 0 && mapS.get(s.charAt(j)) <= mapT.get(s.charAt(j)) ){
                    match++;
                }
                j++;

                b1=true;
            }
            while(i<j && match == t.length() ) {
                if(match == t.length()){
                    if(result == "" || result.length() >= j+1-i){
                        result = s.substring(i,j);
                    }
                }

                mapS.put(s.charAt(i),mapS.getOrDefault(s.charAt(i),0)-1);
                if(mapT.containsKey(s.charAt(i)) && mapS.get(s.charAt(i))<mapT.get(s.charAt(i)) ){
                    match--;
                }
                i++;

                b2=true;
            }

            if(b1==false && b2==false){
                break;
            }

        }

        return result;
    }
}