package student;

/* 
 * This class is meant to contain your algorithm.
 * You should implement the static method: minAndMax()
 * The input is:
 *   an array of Value objects
 *   
 * These objects are comparable using the compareTo() method.
 * Your goal is to find both the minimum and maximum values using at most 1.5 N comparisons.
 * 
 * You should return an array of two Value objects the minimum and maximum values.
 */

import minAndMax.Value;

public class MinAndMax {
	
	// Example routine that just compares the first two values
	public static Value[] minAndMax(Value[] values) {
		Value v0 = values[0];
		Value v1 = values[1];
		
		if (v0.compareTo(v1) < 0)
			return new Value[] {v0, v1};  // make a 2 element array v0 is min and v1 is max
		else
			return new Value[] {v1, v0};  // make a 2 element array v1 is min and v0 is max
	}					
}