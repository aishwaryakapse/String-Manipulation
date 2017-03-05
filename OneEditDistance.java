/*
 * Given two strings S and T, determine if they are both 
 * one edit distance apart.
 */
public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		
		int m = s.length();
		int n = t.length();
		int i = 0;
		int j = 0;
		int count = 0;
		
		if(Math.abs(m - n) > 1) {
			return false;
		}
		while(i < m && j < n) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			}else {
				count++;
				if(count > 1) {
					return false;
				}
				
				if(m > n) {
					i++;
				}else if(m < n) {
					j++;
				}else {
					i++;
					j++;
				}
			}
		}
		if(i < m || j < n) {
			count++;
		}
		
		if(count == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		OneEditDistance oed = new OneEditDistance();
		System.out.println(oed.isOneEditDistance("bird", "birdy"));
	}

}
