package com.leetcode.algorithms.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.leetcode.algorithms.Interval;

public class L056_MergeIntervals {
	/**
	 * 
	 * 56. Merge Intervals
	 * <p>
	 * Total Accepted: 76836 Total Submissions: 289351 Difficulty: Hard
	 * <p>
	 * Given a collection of intervals, merge all overlapping intervals.
	 * 
	 * For example, Given [1,3],[2,6],[8,10],[15,18], return
	 * [1,6],[8,10],[15,18].
	 * 
	 * <p>
	 * Tags Array Sort
	 * 
	 * 1,5 2,6 3,4 7,9
	 * 
	 */
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() == 0)
			return intervals;
		List<Interval> list = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}

		});
		Interval interval = intervals.get(0);
		list.add(interval);
		for (int i = 1; i < intervals.size(); i++) {
			Interval temp = intervals.get(i);
			if (interval.end >= temp.start) {
				interval.end = Math.max(interval.end, temp.end);
			} else {
				interval = temp;
				list.add(interval);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		L056_MergeIntervals solution = new L056_MergeIntervals();

		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 4));
		list.add(new Interval(1, 2));
		list.add(new Interval(5, 7));
		list.add(new Interval(9, 10));
		for (Interval interval : solution.merge(list)) {
			System.out.println("[" + interval.start + ", " + interval.end + "]");
		}
	}

}
