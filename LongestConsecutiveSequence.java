/*Given an unsorted array of integers, find the length of the longest 
 * consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive 
elements sequence should be [1, 2, 3, 4]. Its length is 4.

Your algorithm should run in O(n) complexity.
add, remove and contains methods of HashSet have constant time compplexity
*/
import java.util.*;
public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		//if array is empty, return 0
		if(nums.length == 0) {
			return 0;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for(int e : nums) {
			set.add(e);
		}
		
		for(int e : nums) {
			int left = e-1;
			int right = e+1;
			int count = 1;
			
			while(set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}
			
			while(set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}
			
			max = Math.max(max, count);
		}
		return max;
	}
	public static void main(String[] args) {
		
		int[] arr = {100, 4, 200, 3, 2, 1};
		System.out.println(longestConsecutive(arr));
	}

}
