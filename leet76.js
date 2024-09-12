TC -  O(s.length+t.length)
SC - O(1)

/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
   const map = {};
  t.split('').forEach((c) => { map[c] = (map[c] || 0) + 1; });

  let missing = t.length; // remaining matching count

  let windowStart = 0;

  let start = 0;
  let minLen = Infinity;

  for (let windowEnd = 0; windowEnd < s.length; windowEnd += 1) {
    if (map[s[windowEnd]] > 0) {
      missing -= 1;
    }
    map[s[windowEnd]] -= 1;

    while (missing === 0) { // valid
      if (windowEnd - windowStart < minLen) {
        minLen = windowEnd - windowStart;
        start = windowStart;
      }

      // make it invalid
      if (map[s[windowStart]] === 0) {
        missing += 1;
      }
      map[s[windowStart]] += 1;
      windowStart += 1;
    }
  }
  return minLen === Infinity ? '' : s.substr(start, minLen + 1);
};