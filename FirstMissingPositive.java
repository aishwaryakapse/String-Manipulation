/*
 * Given an unsorted integer array, find the first missing 
 * positive integer. For example, given [1,2,0] return 3 
 * and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant 
space.
 */
public class FirstMissingPositive {
	//find missing positive and zero
	public int firstMissingPositiveAndZero(int[] A) {
		int n = A.length;
		for(int i=0; i<n; i++) {
			//When ith element is not i
			while(A[i] != i) {
				if(A[i] < 0 || A[i] >= n) {
					break;
				}
				
				//handle duplicates
				if(A[i] == A[A[i]]) {
					break;
				}
				
				//swap elements
				int temp = A[i];
				A[i] = A[temp];
				A[temp] = temp;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(A[i] != i) {
				return i;
			}
		}
		
		return n;
	}
	

	//Find missing positive and not zeros
	public int firstMissingPositive(int[] A) {
		int n = A.length;
		for(int i=0; i<n; i++) {
			while(A[i] != i+1) {
				if(A[i] <= 0 || A[i] >= n ) {
					break;
				}
				
				if(A[i] == A[A[i] - 1]) {
					break;
				}
				
				int temp = A[i];
				A[i] = A[temp - 1];
				A[temp-1] = temp;
			}
		}
		
		for(int i=0; i < n; i++) {
			if(A[i] != i+1) {
				return i+1;
			}
		}
		
		return n+1;
	}
	
	public static void main(String[] args) {
		FirstMissingPositive fmp = new FirstMissingPositive();
		int[] A = {-2, 1, 3, 2, 4, 7};
		System.out.println(fmp.firstMissingPositiveAndZero(A));
		System.out.println(fmp.firstMissingPositive(A));
	}

}
