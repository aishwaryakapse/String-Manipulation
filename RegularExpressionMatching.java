/* "." matches any single char, "*" matches zero or more of the preceeding elements
 * 2 basic cases:
 *   - The 2nd character of pattern is "*". -> If the 1st char is not ".", the 1st char of pattern and string should be same.
 *   - The 2nd character of pattern is not "*". -> If the 1st char of pattern is "." or 1st char of pattern == 1st char of 
 *   	string--- continue matching remaining.
 */

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p){
		// base case
		if(p.length() == 0){
			return s.length()==0;
		}
		// special case
		if(p.length() == 1){
			//if length of s = 0, return false
			if(s.length() < 1){
				return false;
			}
			//if 1st does not match, return false
			else if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')){
				return false;
			}
			//otherwise compare rest of the string of s and p
			else{
				return isMatch(s.substring(1),p.substring(1));
			}
		}
		//Case 1: when the 2nd char of p is not "*".
		if(p.charAt(1) != '*'){
			if(s.length() < 1){
				return false;
			}
			if(p.charAt(0) != s.charAt(0) && p.charAt(0) != '.'){
				return false;
			}else{
				return isMatch(s.substring(1), p.substring(1));
			}
		}
		//Case 2: when the 2nd char of p is "*". complex case...
		else{
			// Case 2.1: a char and "*" can mean 0 preceding element
			if(isMatch(s,p.substring(2))){
				return true;
			}
			// Case 2.2: a char and "*" can mean 1 or more preceding elements
			// So check every substring
			int i = 0;
			while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if(isMatch(s.substring(i+1), p.substring(2))){
					return true;
				}
				i++;
			}
		}	
		return false;
	}
	
	
	public boolean isMatchRegex(String s, String p) {
		
		if(p.length() == 0) {
			return s.length() == 0;
		}
		
		if(p.length() == 1 || p.charAt(1) != '*') {
			if(s.length() < 1 || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			}
			return isMatch(s.substring(1), p.substring(1));
		}else {
			int len = s.length();
			int i = -1;
			
			
			while(i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if(isMatch(s.substring(i+1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		RegularExpressionMatching rem = new RegularExpressionMatching();
		String s = "aa";
		String p = ".*";
		boolean result = rem.isMatch(s, p);
		System.out.println("Result : "+result);
		System.out.println(rem.isMatchRegex(s, p));
	}
}