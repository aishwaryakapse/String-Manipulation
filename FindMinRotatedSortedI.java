/*
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 
 * might become 4 5 6 7 0 1 2).

Find the minimum element.You may assume no duplicate 
exists in the array.
 */
public class FindMinRotatedSortedI {
	//Recursive
	public int findMinRec(int[] num) {
		return findMinR(num, 0, num.length - 1);
	}

	public int findMinR(int[] num, int left, int right) {
		if (left == right) {
			return num[left];
		}
		if ((right - left) == 1) {
			return Math.min(num[left], num[right]);
		}
		int middle = left + (right - left) / 2;

		// not rotated
		if (num[left] < num[right]) {
			return num[left];
		} // go right side
		else if (num[middle] > num[left]) {
			return findMinR(num, middle, right);
		} else {
			return findMinR(num, left, middle);
		}
	}
	
	//Iterative
	public int findMinIter(int[] num) {
		if(num == null || num.length == 0) {
			return -1;
		}
		if(num.length == 1) {
			return num[0];
		}
		
		int left = 0;
		int right = num.length-1;
		
		//not rotated
		if(num[left] < num[right]) {
			return num[left];
		}
		
		while(left < right) {
			if(right-left == 1) {
				return num[right]; //or return Math.min(num[right],num[left])
			}
			
			int mid = left + (right - left)/2;
			if(num[mid] > num[left]) {
				left = mid;
			}else {
				right = mid;
			}
		}
		return num[left];
	}
	
	//OR
	public int findMinI(int[] num) {
		if(num == null || num.length == 0) {
			return -1;
		}
		
		int i = 0;
		int j = num.length-1;
		
		while(i <= j) {
			if(num[i]<=num[j]) {
				return num[i];
			}
			int m= i+j/2;
			if(num[m] >= num[i]) {
				i = m+1;
			}else {
				j = m;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		FindMinRotatedSortedI fmr1 = new FindMinRotatedSortedI();
		int[] num = {7, 1, 2, 3, 4, 5, 6};
		System.out.println(fmr1.findMinRec(num));
		System.out.println(fmr1.findMinIter(num));
		System.out.println(fmr1.findMinI(num));
	}
}
