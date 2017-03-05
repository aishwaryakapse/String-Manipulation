/*
 * Given a sorted array and a target value, return the 
 * index if the target is found. If not, return the 
 * index where it would be if it were inserted in order. 
 * You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 -> 2
[1,3,5,6], 2 -> 1
[1,3,5,6], 7 -> 4
[1,3,5,6], 0 -> 0
 */
public class SearchInsertPosition {
	public int searchInsertPositionI(int[] nums, int target) {
		if(nums == null) {
			return -1;
		}
		if(target > nums[nums.length-1]) {
			return nums.length;
		}
		
		if(target < nums[0]) {
			return 0;
		}
		
		int i=0;
		int j=nums.length;
		
		while(i < j) {
			int m=(i+j)/2;
			if(target > nums[m]) {
				i = m+1;
			}else{
				j = m;
			}
		}
		return j;
	}
	
	
	public int searchInsertPositionII(int[] nums, int target) {
		int i=0;
		int j=nums.length-1;
		
		while(i <= j) {
			int mid = (i+j)/2;
			
			if(target > nums[mid]) {
				i=mid+1;
			}else if(target < nums[mid]) {
				j = mid-1;
			}else {
				return mid;
			}
		}
		return i;
	}
	
	
	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = {1, 3, 5, 6};
		int target = 7;
		System.out.println(sip.searchInsertPositionI(nums, target));
		System.out.println(sip.searchInsertPositionII(nums, target));
		
	}

}
