/*
 * Given a string, find the longest substring that contains only two 
 * unique characters. For example, given "abcbbbbcccbdddadacb", the 
 * longest substring that contains 2 unique character is "bcbbbbcccb".
 */
import java.util.*;
public class LongestSubstringTwoUnique {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
			
			if(map.size()>2) {
				max = Math.max(max,  i-start);
				
				while(map.size()>2) {
					char t = s.charAt(start);
					int count = map.get(t);
					if(count > 1) {
						map.put(t,  count-1);
					}else {
						map.remove(t);
					}
					start++;
				}
			}
		}
		max = Math.max(max, s.length()-start);
		return max;
	}
	//K unique
	public int lengthOfLongestKDistinct(String s, int k) {
		if(k == 0 || s == null || s.length() == 0) {
			return 0;
		}
		
		if(s.length() < k) {
			return s.length();
		}
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = k;
		int left = 0;
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
			
			if(map.size() > k) {
				maxLen = Math.max(maxLen, i-left);
				
				while(map.size() > k) {
					char fc = s.charAt(left);
					if(map.get(fc) == 1) {
						map.remove(fc);
					}else {
						map.put(fc,  map.get(fc)-1);
					}
					left++;
				}
			}
		}
		maxLen = Math.max(maxLen, s.length()-left);
		return maxLen;
	}
	
	public static void main(String[] args) {
		LongestSubstringTwoUnique lstu = new LongestSubstringTwoUnique();
		System.out.println(lstu.lengthOfLongestSubstringTwoDistinct("abac"));
		System.out.println(lstu.lengthOfLongestKDistinct("abcadcacacaca", 3));
	}
}
