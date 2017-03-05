/*
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses 
 * substring.

For "(()", the longest valid parentheses substring is "()", 
which has length = 2.
Another example is ")()())", where the longest valid parentheses 
substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

	public static int longestValidParentheses(String s) {
		int validLength = 0;
		int openParenthesisCount = 0;
		int maxValidLength = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char parenthesis = s.charAt(i);
			if(parenthesis == '(') {
				openParenthesisCount++;
			} else {
				if(openParenthesisCount > 0) {
					openParenthesisCount--;
					validLength = validLength + 2;
				} else {
					validLength = 0;
					openParenthesisCount = 0;
				}
			}
			if(maxValidLength < validLength) {
				maxValidLength = validLength;
			}
		}
		return maxValidLength;
	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(((()())"));
	}

}
