
/*Pascals Triangle I
 * Given numRows, generate the first numRows of Pascal's triangle. 
 * For example, given numRows = 5, the result should be:

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
import java.util.*;

public class PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generatePascalI(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0) {
			return result;
		}

		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);

		for (int i = 1; i < numRows; i++) {
			ArrayList<Integer> curr = new ArrayList<Integer>();
			curr.add(1); // first
			for (int j = 0; j < pre.size() - 1; j++) {
				curr.add(pre.get(j) + pre.get(j + 1));
			}
			curr.add(1); // last

			result.add(curr);
			pre = curr;
		}
		return result;
	}
	
	/*Pascals Triangle II
	 * Given an index k, return the kth row of the Pascal's 
	 * triangle. For example, when k = 3, the row is [1,3,3,1].
	 */
	public List<Integer> getRowPascalII(int rowIndex) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0) {
			return result;
		}
		
		result.add(1);
		for(int i =1; i<=rowIndex; i++) {
			for(int j = result.size() - 2; j>=0; j--) {
				result.set(j+1, result.get(j) + result.get(j+1));
			}
			result.add(1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result = pt.generatePascalI(5);

		for (ArrayList<Integer> i : result) {
			for (Integer j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		List<Integer> res = new ArrayList<Integer>();
		res = pt.getRowPascalII(3);
		System.out.println(res);
	}
}
