
/*
 * Given an array nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very 
 * right. You can only see the k numbers in the window. 
 * Each time the sliding window moves right by one position.
 */
import java.util.*;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int[] result = new int[nums.length - k + 1];
		LinkedList<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}

			deque.offer(i);
			if (i + 1 >= k) {
				result[i + 1 - k] = nums[deque.peek()];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum swm = new SlidingWindowMaximum();
		int[] nums = { 1, 2, 4, 5, 3, 5 };
		int[] result = swm.maxSlidingWindow(nums, 3);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
