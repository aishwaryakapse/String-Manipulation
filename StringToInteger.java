/*
 * Implement stringToInt to convert a string to an integer.

Hint: Carefully consider all possible input cases.

Analysis

The following cases should be considered for this problem:

1. null or empty string
2. white spaces
3. +/- sign
4. calculate real value
5. handle min & max
 */
public class StringToInteger {
	public int stringToInt(String s) {
		//Return 0 for null or empty string
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		//Trim white spaces
		s = s.trim();
		
		char flag = '+';
		
		//check negative or positive
		int i = 0;
		if(s.charAt(0) == '-') {
			flag = '-';
			i++;
		}else if(s.charAt(0) == '+') {
			i++;
		}
		
		//use double to store the result
		double result = 0;
		
		//Calculate value
		while(s.length() > i && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
			result = result*10 + (s.charAt(i) - '0');
			i++;
		}
		
		if(flag == '-') {
			result = -result;
		}
		
		//Handle max and min
		if(result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		if(result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		System.out.println(sti.stringToInt("+123450"));
	}

}
