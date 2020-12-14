// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set ans to -1,0,0 containing size of substring, start and end indices
create and map on t containing characters and their number of occurrences

set required to len of dict and set formed, l, r to 0
create window map

while r<len(s)
set or increment entry of s[r] in window
if s[r] is present in dictionary and count matches with window then increment formed
while formed == required and l<=r
if ans[0] is -1 or length is greater than r-l+1 update ans
reduce window[s[l]] check if its less than dict[s[l]] then decrement formed
increment l

increment r

if ans[0] is -1 return ""
else return substring between l, r+1 of ans
*/
package main

import "fmt"

func minWindow(s string, t string) string {
	ans := []int{-1, 0, 0}
	dict := make(map[byte]int)
	for i:=0;i<len(t);i++ {
		_, ok := dict[t[i]]
		if ok {
			dict[t[i]]++
		} else {
			dict[t[i]] = 1
		}
	}
	required := len(dict)
	l := 0
	r := 0
	formed := 0
	window := make(map[byte]int)
	for r < len(s) {
		//r related
		_, ok := window[s[r]]
		if ok {
			window[s[r]]++
		} else {
			window[s[r]] = 1
		}
		c, e := dict[s[r]]
		if e && c == window[s[r]] {
			formed++
		}
		for formed == required && l<=r {
			if ans[0] == -1 || r - l + 1 < ans[0] {
				ans[0] = r - l + 1
				ans[1] = l
				ans[2] = r
			}
			//l related
			window[s[l]]--
			c, e = dict[s[l]]
			if e && window[s[l]] < c {
				formed--
			}
			l++
		}
		r++
	}
	if ans[0] == -1 {
		return ""
	} else {
		return s[ans[1]:ans[2]+1]
	}
}

func MainMinWindowSubs() {
	fmt.Println(minWindow("ADOBECODEBANC", "ABC")) //expected BANC
}
