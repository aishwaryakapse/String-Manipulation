/*
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than 
 * ⌊ n/2 ⌋ times. (assume that the array is non-empty and the 
 * majority element always exist in the array.)
 */
public class MajorityI {
	public int majorityElement(int[] nums) {
		int result = 0;
		int count = 0;
		
		for(int i=0; i<nums.length;i++) {
			if(count ==0) {
				result = nums[i];
			}else if(result == nums[i]) {
				count++;
			}else {
				count--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		MajorityI m1 = new MajorityI();
		int[] nums = {1,2,3,1,1,1,1,1,1};
		System.out.println(m1.majorityElement(nums));
	}

}
