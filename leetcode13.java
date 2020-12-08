class Solution {
	public int romanToInt(String s) {
		int prev = 1000;
		int result = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
			case 'I':
				result += 1;
				prev = 1;
				break;
			case 'V':
				if (5 > prev) {
					result -= (2 * prev);
				}
				result += 5;
				prev = 5;
				break;
			case 'X':
				if (10 > prev) {
					result -= (2 * prev);
				} 
				result += 10;
				prev = 10;
				break;
			case 'L':
				if (50 > prev) {
					result -= (2 * prev);
				}
				result += 50;
				prev = 50;
				break;
			case 'C':
				if (100 > prev) {
					result -= (2 * prev);
				}
				result += 100;
				prev = 100;
				break;
			case 'D':
				if (500 > prev) {
					result -= (2 * prev);
				}
				result += 500;
				prev = 500;
				break;
			case 'M': 
				if (1000 > prev) {
					result -= (2 * prev);
				}
				result += 1000;
				prev = 1000;
				break;
			default: break;
			}
		}
		return result;
	}
}
