/*
 * Given an array of integers, find if the array 
 * contains any duplicates. Your function should 
 * return true if any value appears at least twice 
 * in the array, and it should return false if every 
 * element is distinct.
 */
import java.util.*;
public class ContainsDuplicateI {
	public boolean containsDuplicateI(int[] arr) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i : arr) {
			if(hs.add(i) == false) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		ContainsDuplicateI cd1 = new ContainsDuplicateI();
		int[] arr = {1, 2, 3, 1, 4};
		System.out.println(cd1.containsDuplicateI(arr));
	}

}
