package student;

import java.util.HashMap;

/*
  Find the MODE of an unordered array of integers in AVERAGE CASE linear time.
 */
public class Mode
{
	public static int mode(int[] integers) 
	{
		// starting code just guesses the first value in the array
		int amountOfintegers = integers.length;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int High = 0;
		
		for (int i = 0; i <= amountOfintegers-1; i++)
		{
			Integer index = integers[i];
			Integer amount = map.get(index);

			if(amount == null) 
			{
				map.put(index, 1);
			}
			else 
			{
				if (amount >= High)
				{
					High = amount + 1;
					map.put(-1, index);
					
				}
				map.put(index,amount +1);
			}
		}
		return map.get(-1);
	}
}
