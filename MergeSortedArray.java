/*
 * Given two sorted integer arrays A and B, merge B into A as one 
 * sorted array.

Note:
You may assume that A has enough space to hold additional elements 
from B. The number of elements initialized in A and B are m and n 
respectively.
 */
public class MergeSortedArray {
	
	public void mergeSorted(int[] A, int[] B) {
		int m = 4;
		int n = B.length;
		while(m>0 && n>0) {
			if(A[m-1] > B[n-1]) {
				A[m+n-1] = A[m-1];
				m--;
			}else{
				A[m+n-1] = B[n-1];
				n--;
			}
		}
		
		while(n > 0) {
			A[m+n-1] = B[n-1];
			n--;
		}
		
		while(m > 0) {
			A[m+n-1] = A[m-1];
			m--;
		}
	}
	
	public void mergesortedII(int[] A, int m, int[] B, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		
		while(k>=0) {
			if(j<0 || (i >= 0 && A[i] > B[j])) {
				A[k--] = A[i--];
			}else{
				A[k--] = B[j--];
			}
		}
	}
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		int[] A = new int[7];
		int m = 4;
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 7;
		int[] B = {2, 4, 6};
		
		System.out.print("A: \n{");
		for(int i = 0; i< m; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		System.out.print("B: \n{");
		for(int j = 0; j<B.length; j++) {
			System.out.print(B[j]+" ");
		}
		System.out.print("}");
		System.out.println();
		
		//msa.mergeSorted(A, B);
		msa.mergesortedII(A, 4, B, 3);
		System.out.print("A: \n{");
		for(int i = 0; i< A.length; i++) {
			System.out.print(A[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		
	}
}
