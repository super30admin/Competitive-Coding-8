class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm.put(t.charAt(i), hm.getOrDefault(hm.get(t.charAt(i)),0)+1);
            System.out.println(hm.get(t.charAt(i)));
        }
        int req = hm.size();
        HashMap<Character, Integer> newhm = new HashMap<>();
        int low = 0;
        int high = 0;
        String res = "";
        int count = 0;
        System.out.println(req+" req");
        while(high<s.length()){
            System.out.println("low "+low+" high "+high+" count "+count);
            // if(hm.containsKey(s.charAt(high))){
                newhm.put(s.charAt(high), newhm.getOrDefault(s.charAt(high),0)+1);
                if(newhm.get(s.charAt(high)) == hm.get(s.charAt(high))){
                    count++;
                    System.out.println(low+" "+high+" "+count+" "+req+" "+newhm.get(s.charAt(high))+" "+hm.get('A'));
                }
                    while(req == count){
                        if(res==""||res.length()>high-low+1){
                            res = s.substring(low,high+1);
                        }
                        newhm.put(s.charAt(low), newhm.get(s.charAt(low))-1);
                        if(newhm.get(s.charAt(low))<hm.get(s.charAt(low))){
                            count--;
                        }
                        low++;
                        while(low<s.length() && !hm.containsKey(s.charAt(low)))
                            low++;
                }
                high++;
        }
        return res;
    }
}

//Time complexity : O(S+T)
//Space complexity : O(S+T)
