/*
 * Given two strings s and t, write a function to determine if 
 * t is an anagram of s.
 */
import java.util.*;
public class ValidAnagram {
	//Consider there are only lower case alphabets in the strings
	public boolean isAnagram(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] arr = new int[26];
		for(int i=0; i<s.length(); i++) {
			arr[s.charAt(i) - 'a']++;
			arr[t.charAt(i) - 'a']--;
		}
		
		for(int i : arr) {
			if(i != 0) {
				return false;
			}
		}
		return true;
	}
	
	//if input is unicode character
	public boolean isAnagram1(String s, String t) {
	    if(s.length()!=t.length())
	        return false;
	 
	    HashMap<Character, Integer> map = new HashMap<Character, Integer>();    
	 
	    for(int i=0; i<s.length(); i++){
	        char c1 = s.charAt(i);
	        if(map.containsKey(c1)){
	            map.put(c1, map.get(c1)+1);
	        }else{
	            map.put(c1,1);
	        }
	    }
	 
	    for(int i=0; i<s.length(); i++){
	        char c2 = t.charAt(i);
	        if(map.containsKey(c2)){
	            if(map.get(c2)==1){
	                map.remove(c2);
	            }else{
	                map.put(c2, map.get(c2)-1);
	            }
	        }else{
	            return false;
	        }    
	    }
	 
	    if(map.size()>0)
	        return false;
	 
	    return true;
	}
	
	
	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		String s = "shalaka";
		String t = "kalasha";
		System.out.println(va.isAnagram(s, t));
		System.out.println(va.isAnagram1(s, t));
	}

}
