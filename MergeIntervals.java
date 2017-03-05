import java.util.*;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0) {
			return result;
		}
		
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				if(i1.start != i2.start) {
					return i1.start-i2.start;
				}else{
					return i1.end-i2.end;
				}
			}
		});
		Interval pre = intervals.get(0);
		for(int i=0; i<intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if(curr.start>pre.end) {
				result.add(pre);
				pre = curr;
			}else{
				Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
				pre = merged;
			}
		}
		result.add(pre);
		return result;
	}
	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		List<Interval> set = new ArrayList<Interval>();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		
		set.add(i1);
		set.add(i2);
		set.add(i3);
		set.add(i4);
		
		List<Interval> result = new ArrayList<Interval>();
		result = mi.merge(set);
		
		for(Interval i : result) {
			System.out.println("["+i.start+", "+i.end+"]");		
		}
		
	}

}
