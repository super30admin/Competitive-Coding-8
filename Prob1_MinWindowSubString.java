class Solution {
    int minLen; // To check the window of substring of Min length
    int start;
    int end;
    int count;
    //Indices of substring 
    
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        if(s.length() == 0 || t.length() == 0)  return "";
        
        int i = 0, j = 0;
        count = 0;
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for(int x = 0; x<t.length(); x++){ // Storing all charcters of String t in HashMap with its frequency
            char ch = t.charAt(x);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1 );
        }
        
        HashMap<Character, Integer> sourceMap = new HashMap<>(); // Running hashmap, while iterating string s, we will store only the characters of S which are in String T
        
        while(j < s.length()){ // Iterating on String s
                char c = s.charAt(j);
                sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
                
            
                if(targetMap.containsKey(c)){
                    int c1 = sourceMap.get(c);
                    int c2 = targetMap.get(c);
                    
                    if(c1 == c2){
                        count++;
                    }
                }  
                while(i <= j && count == targetMap.size()){ // When we found all characters of t in current window
                    System.out.println("Current vaue of I AND J = " + i + "  and   " + j);
        
                    if(minLen == 0){ //Initializing very first substing window
                        minLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                    if(minLen != 0 &&  j - i + 1 < minLen){
                        minLen = j - i + 1;
                        start = i;
                        end = j;
                        
                    }
                    char ch = s.charAt(i);
                    sourceMap.put(ch, sourceMap.get(ch).intValue() - 1);
                    if(targetMap.containsKey(ch) && sourceMap.get(ch).intValue() < targetMap.get(ch).intValue() ){
                        count--;
                    }
                    i++;
                }
            j++;
        }
        
        if(minLen == 0) return "";
        System.out.println("Start = " + start + "  end = " + end);
        
        return s.substring(start, end+1);
    }
}




