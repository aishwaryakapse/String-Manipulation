/*
 * Given a pattern and a string str, find if str follows 
 * the same pattern. Here follow means a full match, such 
 * that there is a bijection between a letter in pattern 
 * and a non-empty word in str.
 */
import java.util.*;
public class WordPattern {
	public boolean wordPatternI(String pattern, String str) {
		String[] arr = str.split(" ");
		
		//prevent out of boundary problem
		if(arr.length != pattern.length()) {
			return false;
		}
		
		HashMap<Character, String> map = new HashMap<Character, String>();
		for(int i=0; i<pattern.length(); i++) {
			char c = pattern.charAt(i);
			if(map.containsKey(c)) {
				String value = map.get(c);
				if(!value.equals(arr[i])) {
					return false;
				}
			}else if(map.containsValue(arr[i])) {
				System.out.println("BC");
				return false;
			}
			map.put(c, arr[i]);
		}
		return true;
	}
	
	/*II :
	 * Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
	 */
	//O(n)
	public boolean wordPatternMatchII(String pattern, String str) {
		if(pattern.length() == 0 && str.length() == 0) {
			return true;
		}
		
		if(pattern.length() == 0) {
			return false;
		}
		
		HashMap<Character, String> map = new HashMap<Character, String>();
		return helper(pattern, str, 0, 0, map);
	}
	
	public boolean helper(String pattern ,String str, int i, int j, HashMap<Character, String> map) {
		
		if(i==pattern.length() || j == str.length()) {
			return true;
		}
		
		if(i >= pattern.length() || j>= str.length()) {
			return false;
		}
		
		char c = pattern.charAt(i);
		for(int k=j+1; k<=str.length(); k++) {
			String sub = str.substring(j, k);
			if(!map.containsKey(c) && !map.containsValue(sub)) {
				map.put(c, sub);
				if(helper(pattern, str, i+1, k, map)) {
					return true;
				}
			}else if(map.containsKey(c) && map.get(c).equals(sub)) {
				if(helper(pattern, str, i+1, k, map)) {
					return true;
				}
			}
		}
		return false;
	}
	
	//O(1)
	public boolean wordPatternMatch(String pattern, String str) {
		if(pattern.length() == 0 && str.length() == 0) {
			return true;
		}
		
		if(pattern.length() == 0) {
			return false;
		}
		
		HashMap<Character, String> map = new HashMap<Character, String>();
		HashSet<String> set = new HashSet<String>();
		return helper(pattern, str, 0, 0, map, set);
	}
	
	public boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set) {
		if(i == pattern.length() && j == str.length()) {
			return true;
		}
		if(i >= pattern.length() || j>=str.length()) {
			return false;
		}
		
		char c = pattern.charAt(i);
		for(int k= j+1; k<=str.length(); k++) {
			String sub = str.substring(j, k);
			if(!map.containsKey(c) && !set.contains(sub)) {
				map.put(c, sub);
				set.add(sub);
				if(helper(pattern, str, i+1, k, map, set)) {
					return true;
				}
				map.remove(c);
				set.remove(sub);
			}else if(map.containsKey(c) && map.get(c).equals(sub)){
				if(helper(pattern, str, i+1, k, map, set)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordPattern wp = new WordPattern();
		String pattern = "abcd";
		String str = "a b c d";
		System.out.println(wp.wordPatternI(pattern, str));
	}

}
