/*
 * Given an integer array of size n, find all elements that 
 * appear more than ⌊ n/3 ⌋ times. The algorithm should run in 
 * linear time and in O(1) space.
 */
import java.util.*;
public class MajorityII {
	//Time O(n) and Space O(n)
	public List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : nums) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}else {
				map.put(i, 1);
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > nums.length/3) {
				result.add(entry.getKey());
			}
		}
		return result;
	}
	
	//Time O(n) Space O(1)
	//There can be only 2 number that come more than n/3 times
	public List<Integer> majorityElementBetter(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;
		
		for(int i : nums) {
			if(n1!=null && i==n1.intValue()) {
				c1++;
			}else if(n2!=null && i == n2.intValue()) {
				c2++;
			}else if(c1 == 0) {
				c1 = 1;
				n1 = i;
			}else if(c2 == 0) {
				c2 = 1;
				n2 = i;
			}else {
				c1--;
				c2--;
			}
		}
		
		c1 = c2 = 0;
		for(int i : nums) {
			if(i == n1.intValue()) {
				c1++;
			}else if(i == n2.intValue()){
				c2++;
			}
		}
		if(c1>nums.length/3) {
			result.add(n1);
		}
			
		if(c2 > nums.length/3) {
			result.add(n2);
		}
		return result;
	}
	
	public static void main(String[] args) {
		MajorityII m2 = new MajorityII();
		int[] nums = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 5};
		List<Integer> result1 = new ArrayList<Integer>();
		List<Integer> result2 = new ArrayList<Integer>();
		result1 = m2.majorityElement(nums); 
		result2 = m2.majorityElementBetter(nums);
		System.out.println("O(n) Space : ");
		for(Integer i : result1) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("O(1) Space : ");
		for(Integer i : result2) {
			System.out.print(i+" ");
		}
		
	}

}
