import java.util.*;
public class ValidParentheses {

	public boolean isValidParanthesesI(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if(map.keySet().contains(curr)) {
				stack.push(curr);
			}else if(map.values().contains(curr)) {
				if(!stack.isEmpty() && map.get(stack.peek()) == curr) {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValidParenthesesII(String s) {
		Stack<Character> stack = new Stack<Character>();
		String operator1 = "({[";
		String operator2 = ")}]";
		
		for(int i=0; i<s.length(); i++) {
			if(operator1.contains(s.substring(i, i+1))) {
				int index = operator1.indexOf(s.substring(i, i+1));
				stack.push(operator2.charAt(index));
			}else if(stack.isEmpty()) {
				return false;
			}else {
				//don't understand this code... :(
				char myChar = stack.pop();
				if(myChar != s.charAt(i)) {
					return false;
				}
			}
		}
	
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValidParanthesesI("({[]})"));
		System.out.println(vp.isValidParenthesesII("{}}"));
	}

}
