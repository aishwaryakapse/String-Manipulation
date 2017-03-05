/*
 * /*
 * Given n non-negative integers representing the histogram's 
 * bar height where the width of each bar is 1, find the 
 * area of largest rectangle in the histogram.
 * 
  * For example, given height = [2,1,5,6,2,3], return 10.
  */
//The key to solve this problem is to maintain a stack to 
//store bars' indexes. The stack only keeps the increasing 
//bars.
import java.util.*;
public class LargestRectHist {
	public int largestRectangleArea(int[] height) {
		if(height == null || height.length == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int  i = 0;
		
		while(i < height.length) {
			//push index to stack when the current height is larger than
			//previous one
			if(stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			}else { //calculate max when the curr height is < prev one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i-stack.peek() - 1;
				max = Math.max(h*w, max);
			}
		}
		
		while(!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h*w, max);
		}
		return max;
	}
	
	public static void main(String[] args) {
		LargestRectHist lrh = new LargestRectHist();
		int[] height = {2, 1, 5 , 6 , 2, 3};
		System.out.println(lrh.largestRectangleArea(height));
	}

}
