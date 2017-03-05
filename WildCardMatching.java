/* Support for "?" & "*" */

public class WildCardMatching {
	public boolean isMatch(String s, String p){
		int i = 0; //index for s
		int j = 0; //index for p
		int starIndex = -1;
		int iIndex = -1;
		
		while(i < s.length()){
			if(j < p.length() && (p.charAt(j) == '?' || (p.charAt(j) == s.charAt(i)))){
				++i;
				++j;
			}else if(j < p.length() && p.charAt(j) == '*'){
				starIndex = j;
				j++;
			}else if(starIndex != -1){
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			}else{
				return false;
			}
		}
		
		while(j < p.length() && p.charAt(j) == '*'){
			++j;
		}
		
		return j == p.length();
	}

	public static void main(String[] args) {
		WildCardMatching wcm = new WildCardMatching();
		String s = "aab";
		String p = "*ab";
		boolean result = wcm.isMatch(s, p);
		System.out.println(result);
	}

}