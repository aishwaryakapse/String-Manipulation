/*
 * Given an array of integers and an integer k, 
 * return true if and only if there are two 
 * distinct indices i and j in the array such that 
 * nums[i] = nums[j] and the difference between i 
 * and j is at most k.
 */
import java.util.*;
public class ContainsDuplicateII {
	public boolean containsDuplicateII(int[] arr, int k) {
		
		if(arr == null || arr.length < 2 || k == 0) {
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				int pre = map.get(arr[i]);
				if(i-pre <= k) {
					return true;
				}
			}else{
				map.put(arr[i], i);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 1, 5};
		int k = 2;
		ContainsDuplicateII cd2 = new ContainsDuplicateII();
		System.out.println(cd2.containsDuplicateII(arr, k));
	}

}
