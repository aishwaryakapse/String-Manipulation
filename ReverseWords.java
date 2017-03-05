
public class ReverseWords {
	public String reverseWordsInString(String words) {
		if(words.length() == 0) {
			return "";
		}
		String[] arr = words.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=arr.length-1; i>=0; i--) {
			if(!arr[i].equals("")){
				sb.append(arr[i]).append(" ");
			}
		}
		
		return sb.length() == 0 ? "": sb.substring(0, sb.length()-1);
	}
		
	public String reverseWords(String words) {
		int i = 0;
		char[] arr = words.toCharArray(); 
		
		for(int j = 0; j < arr.length; j++) {
			if(arr[j] == ' '){
				reverse(arr, i, j-1);
				i = j+1;
			}
		}
		
		reverse(arr, i, arr.length-1);
		reverse(arr, 0, arr.length-1);
		String s = String.valueOf(arr);
		return s;
	}
	
	public void reverse(char[] s, int start, int end) {
		while(start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		String s = "The Sky Is Blue And The Roses Are Red";
		System.out.println(s);
		System.out.println(rw.reverseWords(s));
		System.out.println(rw.reverseWordsInString(s));
	}

}
