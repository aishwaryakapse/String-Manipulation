

import java.io.IOException;
import java.util.Stack;

public class RPN {

	public static void main(String[] args) throws IOException{
		String[] tokens = new String[] {"2", "1", "+", "3", "*"};
		System.out.println("The result is: "+evalRPN(tokens));
		System.out.println("The result is: "+evalRPNMod(tokens));
	}
	
	/* For JAVA version 7 and above*/
	public static int evalRPN(String[] tokens){
		int returnValue = 0;
		String operators = "+-*/";
		
		Stack<String> stack = new Stack<String>();
		for(String t: tokens){
			if(!operators.contains(t)){
				stack.push(t);
			}else{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch(t){
				case "+":
					stack.push(String.valueOf(a+b));
					break;
				case "-":
					stack.push(String.valueOf(b-a));
					break;
				case "*":
					stack.push(String.valueOf(a*b));
					break;
				case "/":
					stack.push(String.valueOf(b/a));
					break;
				}
			}
			
		}
		returnValue = Integer.valueOf(stack.pop());
		
		return returnValue;
	}
	
	/* For JAVA version less than 7 which does not allow switch case of string */
	public static int evalRPNMod(String[] tokens){
		int returnValue = 0;
		String operators = "+-*/";
		
		Stack<String> stack = new Stack<String>();
		for(String t: tokens){
			if(!operators.contains(t)){
				stack.push(t);
			}else{
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				int index = operators.indexOf(t);
				switch(index){
				case 0:
					stack.push(String.valueOf(a+b));
					break;
				case 1:
					stack.push(String.valueOf(b-a));
					break;
				case 2:
					stack.push(String.valueOf(a*b));
					break;
				case 3:
					stack.push(String.valueOf(b/a));
					break;
				}
			}
			
		}
		returnValue = Integer.valueOf(stack.pop());
		
		return returnValue;
	}
}
