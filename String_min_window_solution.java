package codes;

public class String_min_window_solution {
	 public String minWindow(String s, String t) {
   	  //base case
	  if (s.length()==0|| t.length()==0) {
		  return "";
	  }
	  
	  //
//	  unique words in t
	  HashMap<Character, Integer> t_count= new HashMap<Character, Integer>();
	  
	  for(int i=0;i<t.length();i++) {
		  t_count.put(t.charAt(i),t_count.getOrDefault(t.charAt(i), 0)+1);
	  }
	  
	  // total unique characters in t
	  int required_size=t_count.size();
	  
//	  left and right pointers
	  int l=0,r=0;
	  
//	  if we matched the length of all unique characters in t
	  int formed=0;
	  
	  
	  HashMap<Character, Integer> window_count= new HashMap<Character, Integer>();
     // ans list of the form (window length, left, right)
	  int[] ans = {-1, 0, 0};
	  
	  while (r<s.length()) {
		  //check the word at r
		  char c = s.charAt(r);
		  window_count.put(c, window_count.getOrDefault(c, 0)+1);
		  
		  // if the frequency of current char equals to the frequency from t_count increase the formed count by 1.
		  
		  if (t_count.containsKey(c)) {
			
		  if (window_count.get(c).intValue()==t_count.get(c).intValue()) {
			  formed++;
		  }
		  }
		  
		  // moving l
//		  only when when we have a desirable window
		  while (l<=r && formed==required_size) {
			   c= s.charAt(l);
			  
			   if (ans[0]==-1||r-l+1<ans[0] ) {
				   ans[0]=r-l+1;
				   ans[1]=l;
				   ans[2]=r;
			   }

		  
		  //remove one entry from current window
		  window_count.put(c, window_count.get(c)-1);
		  
		  
		  // check if the freq in updated window is >= to the freq in t
		  
		  
		  if(t_count.containsKey(c)&&window_count.get(c).intValue()<t_count.get(c).intValue()) {
			  formed--;
		  }
		  
		  l++;
		  
		  
	  }
		  r++;
	  }
	  
	  
	  
	  
	  
	  return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
	
	  
	  
	  
	  

}
}
