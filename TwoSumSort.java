

import java.util.Arrays;

public class TwoSumSort {

	public void hasSum(int[] arr, int sum){
		Arrays.sort(arr);
		int len = arr.length;
		int l=0, r = len-1;
		while(l < r){
			if(arr[l] + arr[r] == sum){
			System.out.println(arr[l] + " + " + arr[r] + " = " + sum);
			break;
			}else if(arr[l] + arr[r] < sum){
				l++;
			}else{
				r--;
			}
		}
		if(l > r){
			System.out.println("No valid pair");
			
		}
	}
	public static void main(String[] args) {
		int[] arr ={1, 2, 3, 4, 5, 6};
		int sum = 5;
		TwoSumSort tss = new TwoSumSort();
		tss.hasSum(arr, sum);

	}

}
