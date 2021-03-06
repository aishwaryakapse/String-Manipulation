/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,

add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
 */

import java.util.*;
public class TwoSumDesign {
	private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
	
	public void add(int number) {
		if(elements.containsKey(number)) {
			elements.put(number, elements.get(number)+1);
		}else {
			elements.put(number, 1);
		}
	}
	
	public boolean find(int value) {
		for(Integer i : elements.keySet()) {
			int target = value - i;
			if(elements.containsKey(target)) {
				if(i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		TwoSumDesign tsd = new TwoSumDesign();
		tsd.add(1);
		tsd.add(1);
		tsd.add(3);
		tsd.add(7);
		tsd.add(5);
		tsd.add(15);
		
		System.out.println(tsd.find(2));

	}

}
