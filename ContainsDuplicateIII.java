/*
 * Given an array of integers, find out whether 
 * there are two distinct indices i and j in the 
 * array such that the difference between nums[i] 
 * and nums[j] is at most t and the difference 
 * between i and j is at most k.
 */
import java.util.*;
public class ContainsDuplicateIII {
	public boolean containsDuplicateIII(int[] arr, int k, int t) {
		if(arr == null || arr.length < 2 || k<0 || t<0) {
			return false;
		}
		
		TreeSet<Long> set = new TreeSet<Long>();
		for(int i=0; i<arr.length; i++) {
			long curr = (long) arr[i];
			
			long leftBoundary = (long) curr - t;
			long rightBoundary = (long) curr + t + 1;
			SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
			if(sub.size() > 0) {
				return true;
			}
			set.add(curr);
			if(i >= k) { // or if(set.size() >= k+1
				set.remove((long)arr[i-k]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		ContainsDuplicateIII cd3 = new ContainsDuplicateIII();
		int[] arr = {1, 2, 4, 50, 6, 3, 1, 5};
		int k = 1;
		int t = 0;
		System.out.println(cd3.containsDuplicateIII(arr, k, t));
	}
}
