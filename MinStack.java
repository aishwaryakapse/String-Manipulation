/*
 * Design a stack that supports push, pop, top, 
 * and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	class Element {
		public int value;
		public int min;
		public Element next;
		
		public Element(int value, int min) {
			this.value = value;
			this.min = min;
		}
	}
	public Element top;
	
	public MinStack() {
		top = null;
	}
	
	public void push(int x) {
		if(top == null) {
			top = new Element(x, x);
		}else {
			Element e = new Element(x, Math.min(x, top.min));
			e.next = top;
			top = e;
		}
	}
	
	public void pop() {
		if(top == null) {
			return;
		}else {
			Element e = top.next;
			top.next = null;
			top = e;
		}
	}
	
	public int top() {
		if(top == null) {
			return -1;
		}else {
			return top.value;
		}
	}
	
	public int getMin() {
		if(top == null) {
			return -1;
		}else {
			return top.min;
		}
	}
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(4);
		ms.push(6);
		ms.push(0);
		ms.pop();
		System.out.println(ms.top());
		ms.push(1);
		System.out.println(ms.getMin());
	}
}
