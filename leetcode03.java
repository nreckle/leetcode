class Solution {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		String prevMax = "";

		for (int i = 0; i < s.length(); i++) {
			int index = prevMax.indexOf(s.charAt(i));

			if (-1 == index) {
				prevMax += s.charAt(i);
			} else {
				prevMax = prevMax.substring(index + 1, prevMax.length()) + s.charAt(i);
			}

			max = max > prevMax.length() ? max : prevMax.length();
		}

		return max;
	}


	/**
	 * via set remove to check whether to get the top element. this can rewrite with
	 * map
	 * 
	 * Set only one special element.
	 */
	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, ans = 0;
		Set<Character> set = new HashSet<Character>();

		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				ans = Math.max(ans, j - i + 1);
				set.add(s.charAt(j++));
			} else {
				set.remove(s.charAt(i++));
			}

		}
		return ans;
	}

	/**
	 * Use map to store the first i position.
	 * 
	 * 1. store each element into map with its position; 
	 * 2. check whether map has
	 * this element, if not, store it; otherwise, reset i position to map value + 1;
	 */
	public int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, ans = 0;
		int n = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
		int[] index = new int[128]; 
		// current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			i = Math.max(index[s.charAt(j)], i);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
		}
		return ans;
	}
}
