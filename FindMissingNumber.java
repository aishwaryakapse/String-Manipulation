import java.util.Arrays;

/*
 * Given an array containing n distinct numbers taken 
 * from 0, 1, 2, ..., n, find the one that is missing 
 * from the array. For example, given nums = [0, 1, 3] 
 * return 2.
 */
public class FindMissingNumber {
	//Math
	public int missingNumMath(int[] nums) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		int n = nums.length;
		return (n*(n+1)/2) - sum;
	}
	
	//Bit
	public int missingNumBit(int[] nums) {
		int miss = 0;
		for(int i=0; i<nums.length; i++) {
			miss ^= (i+1) ^ nums[i];
		}
		return miss;
	}
	
	//Binary Search
	public int missingNumBinS(int[] nums) {
		Arrays.sort(nums);
		int l =0;
		int r = nums.length;
		while(l < r) {
			int m=(l+r)/2;
			if(nums[m] > m) {
				r = m;
			}else {
				l = m+1;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		FindMissingNumber fmn = new FindMissingNumber();
		int[] nums = {0, 2, 3, 4};
		System.out.println(fmn.missingNumMath(nums));
		System.out.println(fmn.missingNumBit(nums));
		System.out.println(fmn.missingNumBinS(nums));
	}
}
