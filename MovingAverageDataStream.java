/*
 * Given a stream of integers and a window size, calculate the moving 
 * average of all integers in the sliding window.
 */
import java.util.*;
public class MovingAverageDataStream {
	LinkedList<Integer> queue;
	int size;
	double avg;
	
	public MovingAverageDataStream(int size) {
		this.queue = new LinkedList<Integer>();
		this.size = size;
	}
	
	public double next(int val) {
		if(queue.size() < this.size) {
			queue.offer(val);
			int sum = 0;
			for(int i : queue) {
				sum += i;
			}
			avg = (double)sum/queue.size();
			return avg;
		}else {
			int head = queue.poll();
			double minus = (double)head/this.size;
			queue.offer(val);
			double add = (double)val/this.size;
			avg = avg + add - minus;
			return avg;
		}
	}
	
	public static void main(String[] args) {
		MovingAverageDataStream mads = new MovingAverageDataStream(3);
		System.out.println(mads.next(1));
		System.out.println(mads.next(3));
		System.out.println(mads.next(5));
		System.out.println(mads.next(2));
		System.out.println(mads.next(13));
		System.out.println(mads.next(4));
		System.out.println(mads.next(6));
		System.out.println(mads.next(89));
	}
}
