

public class RotateArray {
	public void rotate(int[] nums, int k){
		if(nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		if(k > nums.length){
			k = k % nums.length;
		}
		
		int[] result = new int[nums.length];
		
		for(int i=0; i < k; i++){
			result[i] = nums[nums.length-k+i];
		}
		
		int j= 0;
		for(int i=k; i<nums.length; i++){
			result[i] = nums[j];
			j++;
		}
		
		System.arraycopy(result, 0, nums, 0, nums.length);
		
	}
	
	public void bubbleRotate(int[] arr, int order ){
		if(arr == null || order < 0){
			throw new IllegalArgumentException("Illegal Argument!");
		}
		
		for(int i = 0; i < order; i++){
			for(int j = arr.length-1; j > 0; j--){
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}
	
	public void reverseRotate(int[] arr, int order){
		order = order%arr.length;
		
		if(arr == null || order < 0){
			throw new IllegalArgumentException("Illegal Argument!");
		}
		
		int a = arr.length - order;
		
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		
	}
	
	public void reverse(int[] arr, int left, int right){
		if(arr.length == 1){
			return;
		}
		
		while(left < right){
			int temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
		
	}
	
	public void print(int[] nums){
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i] + " ");
		}
	}
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] nums = {1,2,3,4,5,6};
		int k = 4;
		System.out.println("Original Array: ");
		ra.print(nums);
		ra.rotate(nums, k);
		System.out.println();
		System.out.println("New Array: ");
		ra.print(nums);
		
		int[] arr = {12,34,45,65,35,34,53,57,56,75,9,14};
		int order = 6;
		System.out.println();
		System.out.println("Original Array for Bubble Rotate: ");
		ra.print(arr);
		System.out.println();
		ra.bubbleRotate(arr, order);
		System.out.println("New Array after bubble rotate: ");
		ra.print(arr);
		
		System.out.println();
		
		System.out.println("New Array after reverse rotate: ");
		ra.reverseRotate(arr, order);
		ra.print(arr);
	}

}
