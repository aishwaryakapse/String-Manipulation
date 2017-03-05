/*
 * Write a function that takes a string as input and 
 * reverse only the vowels of a string.
 */
import java.util.*;
public class ReverseVowelsString {
	public String reverseVowels(String s) {
		ArrayList<Character> vowelsList = new ArrayList<Character>();
		vowelsList.add('a');
		vowelsList.add('e');
		vowelsList.add('i');
		vowelsList.add('o');
		vowelsList.add('u');
		vowelsList.add('A');
		vowelsList.add('E');
		vowelsList.add('I');
		vowelsList.add('O');
		vowelsList.add('U');
		
		char[] arr = s.toCharArray();
		int i=0;
		int j = s.length()-1;
		while(i < j) {
			if(!vowelsList.contains(arr[i])) {
				i++;
				continue;
			}
			if(!vowelsList.contains(arr[j])) {
				j--;
				continue;
			}
			
			char t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		return new String(arr);
	}
	public static void main(String[] args) {
		ReverseVowelsString rvs = new ReverseVowelsString();
		String s = "Aishwarya Kapse";
		System.out.println(rvs.reverseVowels(s));
	}
}
