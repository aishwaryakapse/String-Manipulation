/*
 * A peak element is an element that is greater than its 
 * neighbors. Given an input array where num[i] ≠ num[i+1], 
 * find a peak element and return its index. The array 
 * may contain multiple peaks, in that case return the 
 * index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞. For example, 
in array [1, 2, 3, 1], 3 is a peak element and your 
function should return the index number 2.
 */

public class FindPeakElement {
	public int findPeakElementIndex(int[] A) {
		int max = A[0];
		int index = 0;
		for(int i=1; i<=A.length-2; i++) {
			int prev = A[i-1];
			int curr = A[i];
			int next = A[i+1];
			
			if(curr > prev && curr > next && curr > max) {
				index = i;
				max = curr;
			}
		}
		if(A[A.length-1] > max) {
			return A.length - 1;
		}
		return index;
	}
	
	public static void main(String[] args) {
		FindPeakElement fpe = new FindPeakElement();
		int[] A = {1, 2, 4, 5, 3, 6};
		System.out.println(fpe.findPeakElementIndex(A));
	}

}
