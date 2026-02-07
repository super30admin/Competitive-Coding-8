class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length())
                return "";
        
        HashMap<Character, Integer> sf = new HashMap<>();
        HashMap<Character, Integer> tf = new HashMap<>();
        int resI = -1;
        int resJ = -1;
        int i =0;
        int matches = 0;

        for(int ptr = 0; ptr< t.length(); ptr++){
            char ch = t.charAt(ptr);
            tf.put(ch, tf.getOrDefault(ch,0)+1);
        }

        for(int j = 0; j< s.length(); j++){
            char ch  = s.charAt(j);

            sf.put(ch, sf.getOrDefault(ch, 0)+1);

            if(tf.containsKey(ch) && sf.get(ch).equals(tf.get(ch)))
                matches++;

            //if all matches found
            while(i<=j && matches == tf.size()){
                char c = s.charAt(i);

                if(resI == -1 || resJ-resI > j-i){
                    resI = i;
                    resJ = j;
                }

                sf.put(c, sf.get(c)-1);
                if(tf.containsKey(c)){
                    if(sf.get(c) < tf.get(c))
                        matches--;
                }
             i++;
            }
        }
     return (resI == -1) ? "" : s.substring(resI,resJ+1);
        
    }
}