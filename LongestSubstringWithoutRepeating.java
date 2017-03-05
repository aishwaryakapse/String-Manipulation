/*
 * Given a string, find the length of the longest substring without 
 * repeating characters. For example, the longest substring without 
 * repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */
import java.util.*;
public class LongestSubstringWithoutRepeating {
	public int lengthOfLongestsubstring(String s) {
		if(s == null) {
			return 0;
		}
		
		boolean[] flag = new boolean[256];
		
		int result = 0;
		int start = 0;
		
		char[] arr = s.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			char curr = arr[i];
			if(flag[curr]) {
				result = Math.max(result, i-start);
				for(int k=start; k<i; k++) {
					if(arr[k] == curr) {
						start = k+1;
						break;
					}
					flag[arr[k]] = false;
				}
			}else {
				flag[curr] = true;
			}
		}
		result = Math.max(arr.length-start, result);
		return result;
	}
	
	//Using HashSet
	public int lengthOfLongestsubstringI (String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int i=0;
		int start = 0;
		while(i<s.length()) {
			char c = s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
			}else {
				max = Math.max(max,  set.size());
				
				while(start<i && s.charAt(start) != c) {
					set.remove(s.charAt(start));
					start++;
				}
				start++;
			}
			i++;
		}
		max = Math.max(max, set.size());
		return max;
	}
	public static void main(String[] args) {
		LongestSubstringWithoutRepeating ls = new LongestSubstringWithoutRepeating();
		String s = "aabcaaabcdefght";
		System.out.println(ls.lengthOfLongestsubstring(s));
		System.out.println(ls.lengthOfLongestsubstringI(s));
	}

}
