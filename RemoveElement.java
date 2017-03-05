/*
 * Given an array and a value, remove all instances of that value 
 * in place and return the new length. (Note: The order of elements 
 * can be changed. It doesn't matter what you leave beyond the new 
 * length.)
 */
public class RemoveElement {
	public int removeElement(int[] A, int element) {
		if(A == null || A.length == 0) {
			return 0;
		}
		
		int i = 0;
		int j = 0;
		
		while(j < A.length) {
			if(A[j] != element) {
				A[i] = A[j];
				i++;
			}
			j++;
		}
		return i;
	}
	
	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		int[] A = {1, 2, 3, 4 ,4 ,4, 5};
		int element = 4;
		System.out.println(re.removeElement(A, element));
	}

}
