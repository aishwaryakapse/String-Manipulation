import java.util.*;
public class ValidPalindrome {

	//using stack data structure
	public boolean isPalindrome(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = s.length();
		
		//consider single char or empty string as a valid palindrome
		if(len < 2) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		int index = 0;
		while(index < len/2) {
			stack.push(s.charAt(index));
			index++;
		}
		
		if(len % 2 == 1) {
			index++;
		}
		
		while(index < len) {
			if(stack.isEmpty()) {
				return false;
			}
			
			char temp = stack.pop();
			if(s.charAt(index) != temp) {
				return false;
			}else {
				index++;
			}
		}
		return true;
	}
	
	//Using two Pointers
	public boolean isValidPalindrome(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		
		s = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("Red rum, sir, is murder"));
		System.out.println(vp.isValidPalindrome("Red rum, sir, is murder"));
	}

}
