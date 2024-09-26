//TC - O(n)
//SC - O(1) - O(26) // maximum number of characters
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length()) return "";
        //store t in the hashmap
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < t.length() ; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }
        //AABCDA t = ABC map A->0 , B->1,c->1
        int counter = 0;
        int minlength = Integer.MAX_VALUE;
        int start = 0;
        int startIndex = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) >= 0){
                    counter++;
                }
            }
            while(t.length() == counter){
                if(minlength > i - start + 1){
                    minlength = i - start + 1;
                    startIndex = start;
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if(map.get(s.charAt(start)) > 0){
                        counter--;
                     }
                }
                start++;
            }
        }
        if(minlength > s.length())return "";
        return s.substring(startIndex , startIndex + minlength);
    }
}
