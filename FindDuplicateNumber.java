/*
 * Given an array nums containing n + 1 integers where each 
 * integer is between 1 and n (inclusive), prove that at least 
 * one duplicate number must exist. Assume that there is only 
 * one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could 
be repeated more than once.
 */
import java.util.*;
public class FindDuplicateNumber {
	//O(n) space
	public int findDuplicate(int[] A) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i : A) {
			if(hs.add(i) == false) {
				return i;
			}
		}
		return -1;
	}
	
	//O(1) space This is possible only when the integer values are
	//between 1 to n
	public int findduplicate(int[] A) {
		int slow = 0;
		int fast = 0;
		do {
			slow = A[slow];
			fast = A[A[fast]];
		}while(slow != fast);
		
		int find = 0;
		
		while(find != slow) {
			slow = A[slow];
			find = A[find];
		}
		return find;
	}
	
	//O(1) Binary Search This is possible only when the integer values are
	//between 1 to n
	public int findDuplicateBS(int[] nums) {
		int l = 1, r = nums.length-1;
		while(l < r) {
			int m = (l+r)/2;
			int c = 0;
			
			for(int i : nums) {
				if(i<=m) {
					c++;
				}
			}
			
			if(c > m) {
				r = m;
			}else {
				l = m+1;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		FindDuplicateNumber fdn = new FindDuplicateNumber();
		
		int[] A = {1, 2, 4, 2, 3};
		System.out.println(fdn.findDuplicate(A));
		System.out.println(fdn.findduplicate(A));
		System.out.println(fdn.findDuplicateBS(A));
	}

}
