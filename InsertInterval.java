import java.util.*;

/* Given a set of non-overlapping and sorted intervals, insert a new interval into the intervals,
 * insert a new interval into the intervals ( merge if necessary ).
*/

class Interval{
	int start, end;
	
	Interval(){
		start = 0;
		end = 0;
	}
	Interval(int s, int e){
		start = s;
		end = e;
	}
}

public class InsertInterval {
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for(Interval interval : intervals) {
			if(interval.end < newInterval.start) {
				result.add(interval);
			}else if(interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			}else if(interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end ));
			}
		}
		result.add(newInterval);
		
		return result;
	}
	
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		Interval i = new Interval(7,10);
		ArrayList<Interval> set = new ArrayList<Interval>();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		
		set.add(i1);
		set.add(i2);
		set.add(i3);
		set.add(i4);
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		result = ii.insert(set, i);
		
		for(Interval inter : result) {
			System.out.println("["+inter.start+", "+inter.end+"]");		
		}
	}
}
