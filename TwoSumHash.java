

import java.util.HashMap;

public class TwoSumHash {

	public void twoSumHash(int[] arr, int sum){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++){
			if(hm.containsKey(arr[i])){
				int index = hm.get(arr[i]);
				System.out.println("The numbers are at location "+index + " and "+ i);
				System.out.println("The number are: "+arr[index]+ " and "+arr[i]);
			}else{
				hm.put(sum - arr[i], i);
			}
		}
	}
	
	public static void main(String[] args) {
		TwoSumHash tsh = new TwoSumHash();
		int[] arr = {10, 20, 9, 3, 7};
		int sum = 29;
		tsh.twoSumHash(arr, sum);
		}

}
