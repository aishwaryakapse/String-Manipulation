/*
 * Given two arrays, write a function to compute their intersection.
 */
import java.util.*;
public class IntersectionTwoArrays {
	//HashSet -- Time : O(n), Space : O(n) --- duplicates not allowed
	public int[] intersectionHS(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i : nums1) {
			set1.add(i);
		}
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i : nums2) {
			if(set1.contains(i)) {
				set2.add(i);
			}
		}
		
		int[] result = new int[set2.size()];
		int i = 0;
		for(int n : set2) {
			result[i++] = n;
		}
		
		return result;
	}
	//HashMap -- HANDLES Duplicates
	public int[] intersectHM(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : nums1) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : nums2) {
			if(map.containsKey(i)) {
				if(map.get(i) > 1) {
					map.put(i, map.get(i)-1);
				}else {
					map.remove(i);
				}
				list.add(i);
			}
		}
		int[] result = new int[list.size()];
		int i=0;
		while(i < list.size()) {
			result[i] = list.get(i);
			i++;
		}
		return result;
	}
	
	//Arrays are sorted
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int p1 = 0, p2 =0;
		while(p1 < nums1.length && p2 < nums2.length) {
			if(nums1[p1] < nums2[p2]) {
				p1++;
			}else if(nums1[p1] > nums2[p2]) {
				p2++;
			}else {
				list.add(nums1[p1]);
				p1++;
				p2++;
			}
		}
		
		int[] result = new int[list.size()];
		int i = 0;
		while(i < list.size()) {
			result[i] = list.get(i);
			i++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		IntersectionTwoArrays ita = new IntersectionTwoArrays();
		int[] nums1 = {1, 5, 6, 3, 6, 3};
		int[] nums2 = {1 , 323, 23, 6, 4, 3};
		
		int[] result = ita.intersectionHS(nums1, nums2);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] res1 = ita.intersectHM(nums1, nums2);
		for(int i : res1) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] res2 = ita.intersectHM(nums1, nums2);
		for(int i : res2) {
			System.out.print(i + " ");
		}
	}
}
