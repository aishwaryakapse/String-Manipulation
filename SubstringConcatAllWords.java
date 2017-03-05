/*
 * You are given a string, s, and a list of words, words, that are 
 * all of the same length. Find all starting indices of substring(s) 
 * in s that is a concatenation of each word in words exactly once 
 * and without any intervening characters.

For example, given: s="barfoothefoobarman" & words=["foo", "bar"], 
return [0,9].
 */
import java.util.*;
public class SubstringConcatAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(s==null||s.length()==0||words==null||words.length==0) {
			return result;
		}
		
		//frequency of words
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String w : words) {
			if(map.containsKey(w)) {
				map.put(w, map.get(w)+1);
			}else {
				map.put(w, 1);
			}
		}
		
		int len = words[0].length();
		
		for(int j=0; j<len; j++) {
			HashMap<String, Integer> currMap = new HashMap<String, Integer>();
			int start = j;
			int count = 0;
			
			for(int i = j; i<=s.length()-len; i=i+len) {
				String sub = s.substring(i, i+len);
				if(map.containsKey(sub)) {
					if(currMap.containsKey(sub)) {
						currMap.put(sub, currMap.get(sub)+1);
					}else {
						currMap.put(sub, 1);
					}
					count++;
					while(currMap.get(sub)>map.get(sub)) {
						String left = s.substring(start, start+len);
						currMap.put(left, currMap.get(left)-1);
						count--;
						start = start + len;
					}
					
					if(count==words.length) {
						result.add(start);
						String left = s.substring(start, start+len);
						currMap.put(left, currMap.get(left)-1);
						count--;
						start = start + len;
					}
				}else {
					currMap.clear();
					start = i+len;
					count = 0;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		SubstringConcatAllWords scaw = new SubstringConcatAllWords();
		List<Integer> result = new ArrayList<Integer>();
		String[] words = {"foo", "bar"};
		result = scaw.findSubstring("barfoothebarfooman", words);
		for(Integer i : result) {
			System.out.println(i);
		}
	}
}
