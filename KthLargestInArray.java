import java.util.PriorityQueue;

/*
 * Find the Kth largest element 
 * in an unsorted array. It is the Kth largest element in the sorted 
 * order, not the Kth distinct element.
 * 
 */
public class KthLargestInArray {
	
	//Quick Select Method
	public int findKthLargest(int[] nums, int k) {
		if(k < 1 || nums == null) {
			return 0;
		}
		return getKth(nums.length-k+1, nums, 0, nums.length-1);
	}
	
	public int getKth(int k, int[] nums, int start, int end) {
		int pivot = nums[end];
		int left = start;
		int right = end;
		
		while(true) {
			while(nums[left] < pivot && left < right) {
				left++;
			}
			while(nums[right] > pivot && right > left) { //not equal to pilot... it will ruin code
				right--;
			}
			
			if(left == right) {
				break;
			}
			
			swap(nums, left, right);
		}
		
		if(k == left + 1) {
			return pivot;
		}else if(k < left + 1) {
			return getKth(k, nums, start, left-1);
		}else{
			return getKth(k, nums, left + 1, end);
		}
	}
	
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
	
	//Using min heap
	public int findKthLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i: nums) {
			q.offer(i);
			if(q.size() > k) {
				q.poll();
			}
		}
		return q.peek();
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 7, 3, 6, 8, 2};
		KthLargestInArray kla = new KthLargestInArray();
		System.out.println(kla.findKthLargest(arr, 2));
	}

}
