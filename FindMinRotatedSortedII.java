//Same as I but here duplicates are allowed
public class FindMinRotatedSortedII {
	//Recursive
	public int findMinRec(int[] num) {
		return findMinR(num, 0, num.length - 1);
	}
	
	public int findMinR(int[] num, int left, int right) {
		if(right == left) {
			return num[left];
		}
		
		if(right == left + 1) {
			return Math.min(num[left], num[right]);
		}
		
		int middle = left + (right - left)/2;
		if(num[right] > num[left]) {
			return num[left];
		}else if(num[left] == num[right]){ //handles duplicates
			return findMinR(num, left+1, right);
		}else if(num[middle] >= num[left]){
			return findMinR(num, middle, right);
		}else {
			return findMinR(num, left, middle);
		}
	}
	
	//Iterative
	public int findMinIter(int[] num) {
		if(num == null || num.length == 0) {
			return -1;
		}
		
		int i = 0;
		int j = num.length - 1;
		
		while(i <= j) {
			while(num[i] == num[j] && i!=j) {
				i++;
			}
			if(num[i] <= num[j]) {
				return num[i];
			}
			int m = (i+j)/2;
			
			if(num[m] >= num[i]) {
				i = m+1;
			}else {
				j = m;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		FindMinRotatedSortedII frs2 = new FindMinRotatedSortedII();
		int[] num = {5, 6, 7, 1, 2, 3, 4};
		System.out.println(frs2.findMinRec(num));
		System.out.println(frs2.findMinIter(num));
	}

}
