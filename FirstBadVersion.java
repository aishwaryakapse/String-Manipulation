/*
 * You are a product manager and currently leading a 
 * team to develop a new product. Unfortunately, the 
 * latest version of your product fails the quality 
 * check. Since each version is developed based on the 
 *previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want 
to find out the first bad one, which causes all the 
following ones to be bad.

You are given an API bool isBadVersion(version) which 
will return whether version is bad. Implement a function 
to find the first bad version. You should minimize the 
number of calls to the API.
 */
public class FirstBadVersion {
	//Recursive
	public int firstBadVersion(int n) {
		return helper(1, n);
	}
	
	public int helper(int i, int j) {
		int m = i + (j - i)/2;
		if(i >= j) {
			return i;
		}
		
		if(isBadVersion(m)) {
			return helper(i, m);
		}else {
			return helper(m+1, j);
		}
	}
	
	public boolean isBadVersion(int m) {
		if(m <= 5 && m >= 3) {
			return true;
		}else {
			return false;
		}
	}
	
	//Iterative
	public int firstBadVersionIter(int n) {
		int i=0, j = n;
		while(i < j) {
			int m = i + (j - i)/2;
			if(isBadVersion(m)) {
				j = m;
			}else {
				i = m+1;
			}
		}
		
		if(isBadVersion(i)) {
			return i;
		}
		return j;
	}
	
	public static void main(String[] args) {
		FirstBadVersion fbv = new FirstBadVersion();
		System.out.println(fbv.firstBadVersion(10));
		System.out.println(fbv.firstBadVersionIter(17));
	}

}
