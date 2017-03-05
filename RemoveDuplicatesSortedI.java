import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in place such that 
 * each element appear only once and return the new length. 
 * Do not allocate extra space for another array, you must do this 
 * in place with constant memory.

For example, given input array A = [1,1,2], your function should 
return length = 2, and A is now [1,2].
 */
import java.util.*;
public class RemoveDuplicatesSortedI {
	//create an array with all unique elements
	public int[] removeDuplicatesSorted(int[] A) {
		if(A == null || A.length < 2) {
			return A;
		}
		
		int i = 0;
		int j = 1;
		
		while(j < A.length) {
			if(A[j] == A[i]) {
				j++;
			}else {
				i++;
				A[i] = A[j];
				j++;
			}
		}
		int[] B = Arrays.copyOf(A, i+1);
		return B;
	}
	
	//Count the number of unique elements
	public int countUnique(int[] A) {
		HashSet<Integer> hs = new HashSet<Integer>();
		int count = 0;
		for(Integer i : A) {
			if(!hs.add(i)) {
				count++;
			}
		}
		return A.length - count;
	}
	public static void main(String[] args) {
		RemoveDuplicatesSortedI rd1 = new RemoveDuplicatesSortedI();
		int[] A = { 1, 1, 2};
		int[] B = rd1.removeDuplicatesSorted(A);
		
		System.out.println(B.length);
		
		System.out.println(rd1.countUnique(A));
	}

}
