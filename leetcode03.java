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
}
