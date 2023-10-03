package student;

import districting.DistrictingTester;

/* 
 * This class is meant to contain your algorithm.
 * You should implement the static method: makeDistricts
 * The input is:
 *   the number of rows and columns of
 *   a 2D array of integer populations in each array cell in the populations 
 *   the number of districts desired
 *   
 * Your task is to break it up into districts that are:
 *   contiguous - (all cells in a region are connected by shared edges)
 *   close to equal in population
 *      
 * You should return a 2D array of the district numbers for each cell. 
 * District number should start at 1.
 * 
 * Note: this assignment can be animated. If you would like to watch your algorithm
 * as it works, you can inserts calls to:
 *          DistrictingTester.show(districts);
 * at any points in your program where it would be useful to see the current state of
 * the districts array. Read more detailed instructions using the [About] button in the
 * scaffold.
 * 
 * The starting code contains example animations calls.
 */
public class Districting {
    public static int[][] makeDistricts(int rows, int cols, int[][] populations, int numDistricts) {
        int[][] districts = new int[rows][cols];  // for storing the district numbers

        // this starting code divides the area in an interesting manner
        // but it is not very even and doesn't even look at the populations  
        int r1 = 0, r2 = rows, c1 = 0, c2 = cols;  // the unallocated region [r1,r2) x [c1,c2)
        
        for (int d = 1; d <= numDistricts; d++) {   // district numbers in [1, numDistricts]
            switch (d % 4) {
            case 0: // slice two rows off top
                fill(districts, r1, c1, r1 + 2, c2, d);
                r1 += 2;
                break;
            case 1: // slice two rows off right
                fill(districts, r1, c2 - 2, r2, c2, d);
                c2 -= 2;
                break;
            case 2: // slice two rows off bottom
                fill(districts, r2 - 2 , c1, r2, c2, d);
                r2 -= 2;
                break;
            case 3: // slice two rows off left 
                fill(districts, r1, c1, r2, c1 + 2, d);
                c1 += 2;
                break;
            }
            DistrictingTester.show(districts);  // you can insert calls like this to animate your algorithm
        }
        
        fill(districts, r1, c1, r2, c2, numDistricts); // give everything else to the last district
        DistrictingTester.show(districts);  // animate 
        
        return districts;
    }   

    // fill in the array region [r1, r2) x [c1, c2) with value d
    public static void fill(int[][] a, int r1, int c1, int r2, int c2, int d) {
        for (int r = r1; r < r2; r++)
            for (int c = c1; c < c2; c++)
                a[r][c] = d;

    }
}