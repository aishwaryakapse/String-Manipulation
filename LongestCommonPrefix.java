/*
 * Write a function to find the longest common prefix string amongst 
 * an array of strings.
 * 
 * To solve this problem, we need to find the two loop 
 * conditions. One is the length of the shortest string. 
 * The other is iteration over every element of the string 
 * array.
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		if (strs.length == 1) {
			return strs[0];
		}

		String minString = strs[0];

		for (String str : strs) {
			if (str.length() < minString.length()) {
				minString = str;
			}
		}

		for (int i = 0; i < minString.length(); i++) {
			for (int j = 0; j < strs.length-1; j++) {
				String s1 = strs[j];
				String s2 = strs[j + 1];
				if (s1.charAt(i) != s2.charAt(i)) {
					minString = minString.substring(0, i);
				}
			}
		}
		return minString;
	}

	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = { "kapse", "kapse", "kap", "kapse" };
		System.out.println(lcp.longestCommonPrefix(strs));
	}

}
