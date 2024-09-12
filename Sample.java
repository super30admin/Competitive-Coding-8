
// Time Complexity : 0(n*n)
// Space Complexity : 0(m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
     func minWindow(_ s: String, _ t: String) -> String {
         if s.count == 0 {
             return ""
         }
         
         var minCount = Int.max
         var hashmap = [Character:Int]()
         var sArray = Array(s)
         
         var minstring = ""
         //hashmap of t
         for char in t {
             if let counter = hashmap[char] {
                 hashmap[char] = counter + 1
             } else {
                 hashmap[char] = 1
             }
         }
         // iterating s
         var i = 0
         var j = 0
         while i < sArray.count  {
            var string = ""
            var hashmap2 = [Character:Int]()
            var count = 0
             var count2 = 0
             while j < sArray.count {
             var char = sArray[j]
             string.append(sArray[j])
             if  let cn = hashmap[char]  {
                 if let counter = hashmap2[char] {
                    if counter < cn {
                     hashmap2[char] = counter + 1
                        count2 += 1
                    }
                 } else {
                     hashmap2[char] = 1
                     count2 += 1
                 }
             }
             count += 1
             if count2 == t.count {
                if count < minCount {
                    minCount = count
                    minstring = string
                }
                j = i + 1
                    break
             }
                 j += 1
             }
             i += 1
         }
         return minstring
     }
