//Time: O(N)
//Space: O(1), HashMaps are constant space

public class minSubStr {
    public String minWindow(String s, String t) {
        String result = "";
        //num of chars found from T string
        int count = t.length();
    
        if(s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        
        //checking string, T
        for(int i = 0; i < t.length(); i++) {
            //a b b c
            /*
            a = 1
            b = 2
            c = 1
            */
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        
//         List<Pair<Character, Integer>> pairS = new List<Pair<Character, Integer>>();
//         //source
//         for(int i = 0; i < s.length; i++) {
//             char c = s.charAt(i);
//             //check 
//             if(map.containsKey(c)) {
//                 pairS.add(new Pair<Character, Integer> (c, i));
//             }
//         }
        
        int left;
        int right;
        int formed;
        int minLen = Integer.MAX_VALUE;     //Minimum length found so far
        
        left = right = formed = 0;
        
        //bounds check
        while(right <= s.length()) {
            if(count == 0) {
                char c = s.charAt(left);
                if(right - left < minLen) {
                    minLen = right-left;
                    result = s.substring(left, right);
                }
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0) count++;
                }
              left++; //shrink from left
            }
            else {
                if(right < s.length()) {
                    char rightC = s.charAt(right);
                    if(map.containsKey(rightC)){
                        map.put(rightC, map.get(rightC) - 1);
                        if(map.get(rightC) >= 0) count--;
                    }
                }
                right++;            
            }
        
        }
        
        return result;
        
    }
}
