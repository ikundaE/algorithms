package student;

/* 
 * This class is meant to contain your algorithm.
 * You should implement the static method: findPeak
 * The input is:
 *   a ReadOnlyArrayList<Integer> that only provides .size() and .get(index)
 *   
 * This array is like a mountain profile. The first part of the array rises with every
 * value to a peak value, and then the values decrease with every value until the end.
 * 
 * Your task is to efficiently find the index of the peak value while looking at as few values
 * as possible. 
 * 
 * You should return the index of the peak value.
 */

import peakFinder.ReadOnlyArrayList;

public class PeakFinder {
	// Example routine that just does linear search until the value decreases
	public static int findPeak(ReadOnlyArrayList<Integer> values) {
		int prevValue;
		int currValue;
		int index;
		
		prevValue = values.get(0);   // start at first value (this could be the peak)
		for (index = 1; index < values.size(); index++) {
			currValue = values.get(index);
			if (currValue < prevValue)
				return index-1;     // values went down so the previous index was the peak
			prevValue = currValue;
		}
		
		return index-1;  // reach end of array, values never decreased so the last value was the peak
	}	
}