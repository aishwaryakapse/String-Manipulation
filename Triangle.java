/*
 * Given a triangle, find the minimum path sum from 
 * top to bottom. Each step you may move to adjacent 
 * numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 
(i.e., 2 + 3 + 5 + 1 = 11).
 */
import java.util.*;
public class Triangle {
	public int minTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
		
		for(int i = 0; i<triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
		
		//iterate from second last row
		for(int i = triangle.size()-2; i >= 0; i--) {
			for(int j = 0; j < triangle.get(i + 1).size()-1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j+1]);
			}
		}
		return total[0];
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l1.add(2);
		triangle.add(l1);
	
		
		l2.add(3);
		l2.add(4);
		triangle.add(l2);
		
		l3.add(6);
		l3.add(5);
		l3.add(7);
		triangle.add(l3);
		
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		triangle.add(l4);
		
		for(ArrayList<Integer> i : triangle) {
			for(Integer j : i) {
				System.out.print(j);
			}
			System.out.println();
		}
		
				
		Triangle t = new Triangle();
		int length = t.minTotal(triangle);
		System.out.println(length);
	}

}
