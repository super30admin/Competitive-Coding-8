/**
 * Brute Force: Using the sliding window , traverse to find the minimum substring with all chars of t.
 * Algo: #1 exapnd the window until all the chars of t are found
 *       #2 then compress the window until the window no more contains all the chars of t
 *       #3 now reiterate from step 1
 *       Thus all windows are found and the min window is chsoen.
 * Time Complexity: O(n) n-length of the string s (every char is visited twice at max)
 * Space: O(k) k-length of the string t--hmap
 */
class Solution {
    public String minWindow(String s, String t) {
        int st=-1,end =-1,i=0,j=0;
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int k=0;k<t.length();k++)
            tmap.put(t.charAt(k),tmap.getOrDefault(t.charAt(k),0)+1);
        //System.out.println(tmap.size());
        int count=0;            //to keep track of the matched chars in the t string
        int maxlen = Integer.MAX_VALUE;
        while(j<s.length() && i<=j ){
            if(tmap.containsKey(s.charAt(j)))
            {
                tmap.put(s.charAt(j),tmap.get(s.charAt(j))-1);
                if(tmap.get(s.charAt(j)) == 0){
                    count++;
                }
            }

            if(count == tmap.size()){

                if(maxlen > (j-i+1))
                {
                    maxlen =Math.min(j-i+1,maxlen);
                    st = i;
                    end = j;
                }
                while(count == tmap.size() && i<=j){
                    //System.out.println(i+" "+count+" "+j);
                    if(tmap.containsKey(s.charAt(i))){
                        tmap.put(s.charAt(i),tmap.get(s.charAt(i))+1);
                        if(tmap.get(s.charAt(i)) > 0)
                            count--;
                    }
                    i++;
                    if(count == tmap.size()){

                        if(maxlen > (j-i+1))
                        {
                            maxlen = Math.min(j-i+1,maxlen);
                            st = i;
                            end = j;
                        }
                    }
                }

            }
            j++;
        }
        if(st==-1 || end == -1) return "";
        return s.substring(st,end+1);
    }
}